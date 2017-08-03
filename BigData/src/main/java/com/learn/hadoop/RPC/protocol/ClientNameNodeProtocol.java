package com.learn.hadoop.RPC.protocol;

/**
 * hdfs客户端跟namenode之间进行远程过程调用使用的协议——接口
 * Created by hechao on 2017/8/1.
 */
public interface ClientNameNodeProtocol {
    public static final long versionID = 100L;
    public String getMetaData(String path);
}
