package com.learn.mapreduce.mapsidejoin;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hechao on 2017/8/7.
 */
public class MapSideJoin {
    public static class MapSideJoinMapper extends Mapper<LongWritable,Text,Text,NullWritable> {
        // 用一个hashmap来加载保存产品信息表
        Map<String,String> pdInfoMap = new HashMap<String, String>();
        Text k = new Text();

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("pdts.txt")));
            String line;
            while (StringUtils.isNotEmpty(line = br.readLine())) {
                String[] fields = line.split(",");
                pdInfoMap.put(fields[0],fields[1]);
            }
            br.close();
        }

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String orderLine = value.toString();
            String[] fields = orderLine.split("\\t");
            String pdName = pdInfoMap.get(fields[1]);
            k.set(orderLine + "\t" + pdName);
            context.write(k,NullWritable.get());
        }

        public static void main(String[] args) throws Exception {
            Configuration conf = new Configuration();

            Job job = Job.getInstance(conf);

            job.setJarByClass(MapSideJoin.class);

            job.setMapperClass(MapSideJoinMapper.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(NullWritable.class);

            FileInputFormat.setInputPaths(job,new Path(args[0]));
            FileOutputFormat.setOutputPath(job,new Path(args[1]));

            // 指定需要缓存一个文件到所有的maptask运行节点工作目录
            /* job.addArchiveToClassPath(archive); */// 缓存jar包到task运行节点的classpath中
            /* job.addFileToClassPath(file); */// 缓存普通文件到task运行节点的classpath中
            /* job.addCacheArchive(uri); */// 缓存压缩包文件到task运行节点的工作目录
            /* job.addCacheFile(uri) */// 缓存普通文件到task运行节点的工作目录

            // 将产品表文件缓存到task工作节点的工作目录中去
            job.addCacheFile(new URI("/Users/hechao/Documents/Learn/BigData/src/main/resources/srcdata/mapjoincache/pdts.txt"));

            job.setNumReduceTasks(0);

            boolean result = job.waitForCompletion(true);
            System.exit(result ? 0 : 1);

        }
    }
}
