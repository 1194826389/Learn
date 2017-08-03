package com.learn.mapreduce.provinceflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

/**
 * K2  V2  对应的是map输出kv的类型
 * Created by hechao on 2017/8/3.
 */
public class ProvincePartitioner extends Partitioner<Text,FlowBean> {


    public static HashMap<String,Integer> provinceDick = new HashMap<String, Integer>();

    static {
        provinceDick.put("136",0);
        provinceDick.put("137",1);
        provinceDick.put("138",2);
        provinceDick.put("139",3);
    }

    public int getPartition(Text key, FlowBean value, int numPartitions) {
        String prefix = key.toString().substring(0,3);
        Integer provincedId = provinceDick.get(prefix);
        return provincedId == null ? 4 : provincedId;
    }
}
