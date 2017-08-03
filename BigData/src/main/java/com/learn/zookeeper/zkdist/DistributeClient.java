package com.learn.zookeeper.zkdist;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechao on 2017/7/23.
 */
public class DistributeClient {
    private static final String connectString = "cm1:2181,cm2:2181,cm3:2181";
    private static final int sessionTimeout = 2000;
    private static final String parentNode = "/servers";


    private volatile List<String> serverList;
    private ZooKeeper zk = null;

    /**
     * 创建zk客户端连接
     * @throws IOException
     */
    public void getConnect() throws IOException {
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

            public void process(WatchedEvent event) {
                // 收到时间通知后的回调函数（应该是我们自己的事件处理逻辑）

                try {
                    // 重新更新服务器列表，并且注册了监听
                    getServerList();
                } catch (Exception e) {

                }
            }
        });
    }

    /**
     * 业务功能
     */
    public void handleBussiness() throws InterruptedException {
        System.out.println("client 正在工作...");
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 获取服务器信息列表
     * @throws Exception
     */
    public void getServerList() throws Exception {
        // 获取服务器子节点，并且对父节点进行监听
        List<String> children = zk.getChildren(parentNode,true);
        List<String> servers = new ArrayList<String>();
        for (String child:children) {
            // child只是子节点的节点名
            byte[] data = zk.getData(parentNode+"/"+child,false,null);
            servers.add(new String(data));
        }

        serverList = servers;

        // 答应服务器列表
        System.out.println(serverList);
    }

    public static void main(String[] args) throws Exception {
        //获取zk连接
        DistributeClient client = new DistributeClient();
        client.getConnect();
        // 获得服务器列表
        client.getServerList();

        // 业务功能
        client.handleBussiness();
    }
}
