package com.learn.sparkstreaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by hechao on 2017/7/15.
 */
public class HDFSWordCount {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf().setAppName("HDFSWordCount").setMaster("local[5]");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(5));
        JavaDStream<String> lines = jssc.textFileStream("hdfs://10.242.109.2:8020/user/che/wordcount_dir");

        JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });



        JavaPairDStream<String,Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s,1);
            }
        });



        JavaPairDStream<String,Integer> wordCounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

        wordCounts.print();

        jssc.start();
        jssc.awaitTermination();
        jssc.stop();
    }
}
