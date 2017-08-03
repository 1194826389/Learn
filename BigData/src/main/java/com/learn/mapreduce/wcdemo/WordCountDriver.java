package com.learn.mapreduce.wcdemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 * Created by hechao on 2017/8/2.
 */
public class WordCountDriver {
    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            args = new String[2];
            args[0] = "hdfs://CM3:9000/wordcout/input/wordcount.txt";
            args[1] = "hdfs://CM3:9000/wordcout/input/output10";
        }
        Configuration conf = new Configuration();
        conf.set("yarn.resourcmanager.hostname","CM3");

        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        Job job = Job.getInstance(conf);

        /*job.setJar("/home/hadoop/wc.jar");*/
        //指定本程序的jar包所在的本地路径
        job.setJarByClass(WordCountDriver.class);

        // 指定本业务job要使用的mapper/Reducer业务类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        //指定mapper输出数据的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //指定最终输出的数据的kv类型
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //指定job的输入原始文件所在目录
        FileInputFormat.setInputPaths(job,new Path(args[1]));
        //指定job的输出结果所在目录
        FileOutputFormat.setOutputPath(job,new Path(args[2]));

        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);


    }
}
