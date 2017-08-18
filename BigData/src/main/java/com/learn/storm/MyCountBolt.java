package com.learn.storm;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hechao on 2017/8/18.
 */
public class MyCountBolt extends BaseRichBolt {
    private OutputCollector collector;
    Map<String,Integer> map = new HashMap<String, Integer>();
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    @Override
    public void execute(Tuple input) {
        String word = input.getStringByField("word");
        Integer num = input.getIntegerByField("num");
        System.out.println(Thread.currentThread().getId() + "       word:" + word);
        if (map.containsKey(word)) {
            Integer count = map.get(word);
            map.put(word,count + num);
        } else {
            map.put(word,num);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        // 不输出
    }
}
