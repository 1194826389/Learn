package com.learn.hadoop.RPC.client;

import com.learn.hadoop.RPC.protocol.LoginServiceProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by hechao on 2017/8/1.
 */
public class UserLoginAction {

    public static void main(String[] args) throws IOException {
        LoginServiceProtocol loginServiceProtocol = RPC.getProxy(LoginServiceProtocol.class,100L,new InetSocketAddress("localhost",9999),new Configuration());
        String login = loginServiceProtocol.login("che","12341234");
        System.out.println(login);
    }
}
