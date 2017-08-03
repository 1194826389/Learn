package com.learn.sparkstreaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hechao on 2017/7/11.
 */
public class WordCount {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf().setAppName("WordCount").setMaster("local[2]");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost",9999);
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

//        JavaPairDStream<String,Integer> wordCounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
//            public Integer call(Integer integer, Integer integer2) throws Exception {
//                return integer + integer2;
//            }
//        });

//        wordCounts.print();



        // updateStateByKey operation

        Function2<List<Integer>,Optional<Integer>,Optional<Integer>> updateFunction = new Function2<List<Integer>, Optional<Integer>, Optional<Integer>>() {
            public Optional<Integer> call(List<Integer> values, Optional<Integer> state) throws Exception {
                Integer newSum = 0;
                return Optional.of(newSum);
            }
        };


        JavaPairDStream<String,Integer> rungingCounts = pairs.updateStateByKey(updateFunction);
        rungingCounts.print();
        jssc.checkpoint(".");
        jssc.start();
        jssc.awaitTermination();


        // window operation

        Function2<Integer,Integer,Integer> reduceFunc = new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        };

        JavaPairDStream<String,Integer> windowWordCounts = pairs.reduceByKeyAndWindow(reduceFunc,Durations.seconds(30),Durations.seconds(10));

//        windowWordCounts.print();
//        jssc.start();
//        jssc.awaitTermination();
    }
}
