package com.learn.hadoop.RPC.service;

import com.learn.hadoop.RPC.protocol.ClientNameNodeProtocol;
import com.learn.hadoop.RPC.protocol.LoginServiceProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;

/**
 * Created by hechao on 2017/8/1.
 */
public class hadoopRPCServer {

    public static void main(String[] args) throws Exception {
        Builder builder1 = new Builder(new Configuration());
        builder1.setBindAddress("localhost")
                .setPort(8888)
                .setProtocol(ClientNameNodeProtocol.class)
                .setInstance(new NameNodeSystem());
        Server server1 = builder1.build();
        System.out.println("server1启动了。。。。。");
        server1.start();

        Builder builder2 = new Builder(new Configuration());
        builder2.setBindAddress("localhost").setPort(9999)
                .setProtocol(LoginServiceProtocol.class)
                .setInstance(new LoginServiceImpl());
        Server server2 = builder2.build();
        System.out.println("server2启动了.....");
        server2.start();

    }
}
