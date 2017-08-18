package com.learn.mapreduce.logenhance;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hechao on 2017/8/8.
 */
public class LogEnhance {
    static class LogEnhanceMapper extends Mapper<LongWritable,Text,Text,NullWritable> {
        Map<String,String> ruleMap = new HashMap<String, String>();
        Text k = new Text();
        NullWritable v = NullWritable.get();

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {

            ruleMap.put("http://proxy.51mrp.com/image","somecontent");
            ruleMap.put("http://maps.google.com/maps/api/geocode/json?latlng=34.75704574584961,113.6663589477539&language=zh-CN&sensor=true","somecontent");
        }

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            Counter counter = context.getCounter("malformed","malformedline");
            String line = value.toString();
            String[] fields = StringUtils.split(line,'\t');
            try {
                String url = fields[28];
                String content_tag = ruleMap.get(url);
                if (content_tag == null) {
                    k.set(url + "\t" + "tocrawl" + "\n");
                    context.write(k,v);
                } else {
                    k.set(line + "\t" + content_tag + "\n");
                    context.write(k,v);
                }
            } catch (Exception e) {
                counter.increment(1);
            }
        }
    }

    public static void main(String[] args) throws Exception{

        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);

        job.setJarByClass(LogEnhance.class);

        job.setMapperClass(LogEnhanceMapper.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        // 要控制不同的内容写往不同的目标路径，可以采用自定义outputformat的方法
        job.setOutputFormatClass(LogEnhanceOutputFormat.class);

        FileInputFormat.setInputPaths(job,new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/srcdata/LogEnhance/"));
        // 尽管我们用的是自定义outputformat，但是它是继承制fileoutputformat
        // 在fileoutputformat中，必须输出一个_success文件，所以在此还需要设置输出path
        FileOutputFormat.setOutputPath(job,new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/output/"));

        // 不需要reducer
        job.setNumReduceTasks(0);
        job.waitForCompletion(true);
        System.exit(0);
    }
}
