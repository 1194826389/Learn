package com.learn.mapreduce.weblogwash;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by hechao on 2017/8/7.
 */
public class WeblogPreProcess {
    static class WeblogPreProcessMapper extends Mapper<LongWritable,Text,Text,NullWritable> {
        Text k = new Text();
        NullWritable v = NullWritable.get();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            WebLogBean webLogBean = WebLogParser.parser(line);

            if (!webLogBean.isValid()) {
                return;
            }
            k.set(webLogBean.toString());
            context.write(k,v);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(WeblogPreProcess.class);

        job.setMapperClass(WeblogPreProcessMapper.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job, new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/srcdata/webloginput"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/output/WeblogPreProcess"));

        job.waitForCompletion(true);
    }
}
