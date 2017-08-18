package com.learn.storm;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * Created by hechao on 2017/8/18.
 */
public class MySplitBolt extends BaseRichBolt {
    private OutputCollector collector;
    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    // 被storm框架 while(true) 循环调用  传入参数tuple
    @Override
    public void execute(Tuple input) {
        String line = input.getStringByField("stormbrief");
        String[] arrWords = line.split(" ");
        for (String word : arrWords) {
            collector.emit(new Values(word,1));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word","num"));
    }
}
