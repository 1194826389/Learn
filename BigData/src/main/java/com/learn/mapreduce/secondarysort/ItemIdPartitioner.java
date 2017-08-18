package com.learn.mapreduce.secondarysort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 这里的<key，value> 和mapper输出的<key，value>应该要对应起来.mapper的产生溢出数据是按照getPartition方法中的逻辑决定分配到哪个partition。具体可以看mapreducer的原理图
 * Created by hechao on 2017/8/8.
 */
public class ItemIdPartitioner extends Partitioner<OrderBean,NullWritable> {
    @Override
    public int getPartition(OrderBean orderBean, NullWritable nullWritable, int numReduceTasks) {
        //相同id的订单bean，会发往相同的partition
        //而且，产生的分区数，是会跟用户设置的reduce task数保持一致
        return (orderBean.getItemid().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
