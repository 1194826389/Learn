package com.learn.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/7/23.
 */
public class SampleZKClient {
    private static final String connectString = "cm1:2181,cm2:2181,cm3:2181";
    private static final int sessionTimeout = 2000;

    private ZooKeeper zkClient;
    @Before
    public void init() throws Exception {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

            public void process(WatchedEvent event) {
                // 收到时间通知后的回调函数（应该是我们自己的事件处理逻辑）
                System.out.println(event.getType() + "--" + event.getPath());
                try {
                    zkClient.getChildren("/",true);
                } catch (Exception e) {

                }
            }
        });

    }

    /**
     * 数据的增删改查
     */

    // 创建数据节点到zk集群中
    @Test
    public void testCreate()  throws Exception{

        String nodeCreate = zkClient.create("/idea","hellozk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //上传的数据可以是任何类型，但是要转化为byte类型

    }

    // 从zk集群获取子节点
    @Test
    public void testGetChildren()  throws Exception{

        List<String> children = zkClient.getChildren("/locks",true);
        for (String child:children) {
            System.out.println(child);
        }
        TimeUnit.SECONDS.sleep(1);
    }

    // 判断节点是否存在
    @Test
    public void testExist() throws Exception {
        Stat stat = zkClient.exists("/locks",false);
        System.out.println(stat ==null?"not exist":"exist");
    }

    //获取znode的数据
    @Test
    public void testGetData() throws Exception {
        byte[] data = zkClient.getData("/idea",false,null);
        System.out.println(new String(data));
    }

    //删除节点
    @Test
    public void testDeletezNode() throws Exception {
        // 参数2，指定要删除的版本，-1表示删除所有版本
        zkClient.delete("/idea1",-1);
    }

    //修改节点
    @Test
    public void testSetzNode() throws Exception {
        // 参数2，指定要删除的版本，-1表示删除所有版本
        zkClient.setData("/idea","i miss u".getBytes(),-1);
        byte[] data = zkClient.getData("/idea",false,null);
        System.out.println(new String(data));
    }
}
