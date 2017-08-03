package com.learn.hadoop.RPC.client;

import com.learn.hadoop.RPC.protocol.ClientNameNodeProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;

/**
 * Created by hechao on 2017/8/1.
 */
public class MyHdfsClient {
    public static void main(String[] args) throws Exception {
        ClientNameNodeProtocol namenode = RPC.getProxy(ClientNameNodeProtocol.class, 1L,
                new InetSocketAddress("localhost", 8888), new Configuration());
        String metaData = namenode.getMetaData("/angela.mygirl");
        System.out.println(metaData);
    }
}
