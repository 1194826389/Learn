package com.learn.zookeeper.zkdistlock;

import org.apache.zookeeper.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hechao on 2017/7/24.
 */
public class DistributedlockMyZKClient {
    private static final int SESSION_TIMEOUT= 200000;
    private ZooKeeper zkClient;
    private String connectString = "cm1:2181,cm2:2181,cm3:2181";
    private String lockNode = "/locks";
    private String subNode = "/sub";
    private volatile String myPath;

    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * 连接zookeeper
     */
    public void connectZookeeper() throws Exception {

        zkClient = new ZooKeeper(connectString, SESSION_TIMEOUT, new Watcher() {
            public void process(WatchedEvent event) {
                try {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        latch.countDown();
                    }

                    System.out.println(event.getType() + "----" + event.getPath() + "----" + myPath);
                    if (event.getType() == Event.EventType.NodeChildrenChanged && event.getPath().equals(lockNode)) {
                            List<String> childrenNodes = zkClient.getChildren(lockNode,true);
                            Collections.sort(childrenNodes);
                            String myNode = myPath.substring((lockNode + "/").length());
                            System.out.println(myNode + "--index: "+ childrenNodes.indexOf(myNode));
                            if (childrenNodes.indexOf(myNode) == 0) {
                                dosomething();

                            }
                        }
                    }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        latch.await();
        zkClient.sync(lockNode,null,null);

        myPath = zkClient.create(lockNode + subNode,null, ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);

        Thread.sleep(10);

        List<String> childrenNodes = zkClient.getChildren(lockNode,true);
        if (childrenNodes.size() == 1) {
            dosomething();
        }


    }


    public void dosomething() throws Exception {
        try {
            System.out.println("gain lock: " + myPath);
            Thread.sleep(100000);
            // do something
        } finally {
            System.out.println("finished: " + myPath);
            // 将thisPath删除, 监听thisPath的client将获得通知
            // 相当于释放锁
            zkClient.delete(this.myPath, -1);
        }

    }

    public static void main(String[] args) throws Exception {
        DistributedlockMyZKClient clientlockMy = new DistributedlockMyZKClient();
        clientlockMy.connectZookeeper();
        Thread.sleep(Long.MAX_VALUE);
    }
}
