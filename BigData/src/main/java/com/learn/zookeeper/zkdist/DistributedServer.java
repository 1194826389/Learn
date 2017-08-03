package com.learn.zookeeper.zkdist;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by hechao on 2017/7/23.
 */
public class DistributedServer {
    private static final String connectString = "cm1:2181,cm2:2181,cm3:2181";
    private static final int sessionTimeout = 2000;
    private static final String parentNode = "/servers/";
    private ZooKeeper zk = null;
    // 获取zk连接
    public void getConnect() throws IOException {
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

            public void process(WatchedEvent event) {
                // 收到时间通知后的回调函数（应该是我们自己的事件处理逻辑）
                System.out.println(event.getType() + "--" + event.getPath());
                try {
                    zk.getChildren("/",true);
                } catch (Exception e) {

                }
            }
        });
    }

    /**
     * 注册服务器
     * @param hostname
     * @throws Exception
     */
    public void registerServer(String hostname) throws Exception {
        String createNode = zk.create(parentNode + "server",hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + "is online.." + createNode);
    }

    /**
     * 业务功能
     */
    public void handleBussiness(String hostname) throws InterruptedException {
        System.out.println(hostname + "正在工作...");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {

        // 获取zk链接
        DistributedServer server = new DistributedServer();
        server.getConnect();

        // 利用zk链接注册服务器信息
        server.registerServer(args[0]);

        server.handleBussiness(args[0]);
    }
}
