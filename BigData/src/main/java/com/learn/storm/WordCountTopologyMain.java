package com.learn.storm;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * Created by hechao on 2017/8/18.
 */
public class WordCountTopologyMain {
    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        TopologyBuilder topologyBuilder = new TopologyBuilder();
        topologyBuilder.setSpout("mySpout",new MySpout(),2);
        topologyBuilder.setBolt("mySplitBolt",new MySplitBolt(),2).shuffleGrouping("mySpout");
        topologyBuilder.setBolt("myCountBolt",new MyCountBolt(),4).fieldsGrouping("mySplitBolt",new Fields("word"));

        //2、创建一个configuration，用来指定当前topology 需要的worker的数量
        Config config = new Config();
        config.setNumWorkers(2);

        //3、提交任务有两种模式
        // 集群模式
        StormSubmitter.submitTopology("mywordcount",config,topologyBuilder.createTopology());
        // 本地模式
//        LocalCluster localCluster = new LocalCluster();
//        localCluster.submitTopology("mywordcount",config,topologyBuilder.createTopology());
    }
}
