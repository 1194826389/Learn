package com.learn.mapreduce.secondarysort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;

/**
 * Created by hechao on 2017/8/8.
 */
public class SecondarySort {
    static class SecondarySortMapper extends Mapper<LongWritable,Text,OrderBean,NullWritable> {

        OrderBean bean = new OrderBean();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] fields = StringUtils.split(line,',');
            bean.set(new Text(fields[0]),new DoubleWritable(Double.parseDouble(fields[2])));
            context.write(bean, NullWritable.get());
        }
    }

    static class SecondarySortReducer extends Reducer<OrderBean,NullWritable,OrderBean,NullWritable> {

        //在设置了groupingcomparator以后，这里收到的kv数据 就是：  <1001 87.6>,null  <1001 76.5>,null  ....
        //此时，reduce方法中的参数key就是上述kv组中的第一个kv的key：<1001 87.6>
        //要输出同一个item的所有订单中最大金额的那一个，就只要输出这个key

        //到达reduce时，相同id的所有bean已经被看成一组，且金额最大的那个一排在第一位,所以key取的就是金额最大的那个一排在第一位的那个bean
        @Override
        protected void reduce(OrderBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
            context.write(key,NullWritable.get());
        }
    }

    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(SecondarySort.class);

        job.setMapperClass(SecondarySortMapper.class);
        job.setReducerClass(SecondarySortReducer.class);

        job.setOutputKeyClass(OrderBean.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job,new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/srcdata/secondarysort"));
        FileOutputFormat.setOutputPath(job,new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/output"));

        //在此设置自定义的Groupingcomparator类 ,根据mapreducer原理图，来理解该方法的作用，作用是:在reducer阶段,key是按照ItemidGroupingComparator类的compared逻辑分组。
        job.setGroupingComparatorClass(ItemidGroupingComparator.class);

        //在此设置自定义的partitioner类,根据mapreducer原理图，来理解该方法的作用，作用是: 在mapper阶段产生的数据是按照ItemIdPartitioner中getPartition方法决定分区逻辑。
        job.setPartitionerClass(ItemIdPartitioner.class);

        job.setNumReduceTasks(2);
        job.waitForCompletion(true);
    }

}
