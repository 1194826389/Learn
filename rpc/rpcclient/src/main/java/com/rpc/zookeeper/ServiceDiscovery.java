package com.rpc.zookeeper;


import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.jboss.netty.util.internal.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hechao on 2017/7/27.
 */
public class ServiceDiscovery {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceDiscovery.class);
    private ZooKeeper zk;
    private volatile List<String> serverAddressList = new ArrayList<String>();

    private CountDownLatch latch = new CountDownLatch(1);

    private String zkConnectString;


    /**
     * 连接zk服务，并且监听ZK_REGISTRY_PATH节点
     * @param zkConnectString
     */
    public ServiceDiscovery(String zkConnectString) {
        try {
            this.zkConnectString = zkConnectString;
            connectZKServer();
            if (this.zk != null) {
                watchNodeAndSetserverAddressList();
            }
        } catch (Exception e) {
            LOGGER.error("",e);
        }
    }

    /**
     * 发现新节点
     *
     * @return
     */
    public String discover() {
        String registryAdderss = null;
        int size = serverAddressList.size();
        // 存在新节点，使用即可
        if (size > 0) {
            if (size == 1) {
                registryAdderss = serverAddressList.get(0);
                LOGGER.info("using only registryAdderss: {}" ,registryAdderss);
            } else {
                registryAdderss = serverAddressList.get(ThreadLocalRandom.current().nextInt(size));
                LOGGER.info("using random registryAdderss: {}" ,registryAdderss);
            }
        }
        return registryAdderss;
    }

    /**
     * 连接zk服务
     * @throws Exception
     */
    private void connectZKServer() throws Exception {
        zk = new ZooKeeper(zkConnectString, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    latch.countDown();
                }
            }
        });
    }

    /**
     * 监听ZK_REGISTRY_PATH节点，并设置serverAddressList
     * @throws Exception
     */
    private void watchNodeAndSetserverAddressList() throws Exception{
        // 获取ZK_REGISTRY_PATH节点的所有子节点
        List<String> nodeList = zk.getChildren(Constant.ZK_REGISTRY_PATH, new Watcher() {
            public void process(WatchedEvent event) {
                if (event.getType() == Event.EventType.NodeChildrenChanged) {
                    try {
                        // 节点改变
                        watchNodeAndSetserverAddressList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 循环子节点
        List<String> serverAddressList = new ArrayList<String>();
        for (String node : nodeList) {
            // 获取节点中的服务器地址
            byte[] bytes = zk.getData(Constant.ZK_REGISTRY_PATH + "/" + node, false, null);
            // 存储到list中
            serverAddressList.add(new String(bytes));
        }
        LOGGER.info("serverAddressList: {}" , serverAddressList);
        // 将节点信息记录在成员变量
        this.serverAddressList = serverAddressList;
    }


}
