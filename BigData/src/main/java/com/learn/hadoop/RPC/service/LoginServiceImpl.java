package com.learn.hadoop.RPC.service;

import com.learn.hadoop.RPC.protocol.LoginServiceProtocol;

/**
 * Created by hechao on 2017/8/1.
 */
public class LoginServiceImpl implements LoginServiceProtocol {
    @Override
    public String login(String username, String password) {

        System.out.println(username + "你总算来了，等死我了");


        return username + "successfully loged in , welcome......";
    }
}
