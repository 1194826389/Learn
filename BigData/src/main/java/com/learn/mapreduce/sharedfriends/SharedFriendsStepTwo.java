package com.learn.mapreduce.sharedfriends;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by hechao on 2017/8/7.
 */
public class SharedFriendsStepTwo {

    static class SharedFriendsStepTwoMapper extends Mapper<LongWritable,Text,Text,Text> {

        Text k = new Text();
        Text v = new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String[] friend_persons = line.split("\\t");
            String friend = friend_persons[0];
            String[] persons = friend_persons[1].split(",");
            Arrays.sort(persons);
            for (int i = 0; i < persons.length - 1; i++) {
                for (int j = 0; j < persons.length;j++) {
                    // 发出 <人-人，好友> ，这样，相同的“人-人”对的所有好友就会到同1个reduce中去
                    k.set(persons[i] + "-" + persons[j]);
                    v.set(friend);
                    context.write(k,v);
                }
            }
        }
    }

    static class SharedFriendsStepTwoReducer extends Reducer<Text,Text,Text,Text> {
        @Override
        protected void reduce(Text person_person, Iterable<Text> friends, Context context) throws IOException, InterruptedException {
            StringBuffer sb = new StringBuffer();
            for (Text friend : friends) {
                sb.append(friend);
            }
            context.write(person_person,new Text(sb.toString()));
        }
    }

    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf);
        job.setJarByClass(SharedFriendsStepTwo.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setMapperClass(SharedFriendsStepTwoMapper.class);
        job.setReducerClass(SharedFriendsStepTwoReducer.class);

        FileInputFormat.setInputPaths(job, new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/output/SharedFriendsStepOne/part-r-00000"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/output/SharedFriendsStepTwoMapper"));

        job.waitForCompletion(true);
    }
 }
