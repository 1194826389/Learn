package com.rpc.zookeeper;

/**
 * 常用常量
 * Created by hechao on 2017/7/27.
 */
public class Constant {
    public static final int ZK_SESSION_TIMEOUT = 5000;//zk超时时间

    public static final String ZK_REGISTRY_PATH = "/serverregistry";//注册节点
    public static final String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/server";//节点
}
