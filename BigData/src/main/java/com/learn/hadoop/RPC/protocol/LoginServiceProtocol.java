package com.learn.hadoop.RPC.protocol;

/**
 * Created by hechao on 2017/8/1.
 */
public interface LoginServiceProtocol {
    public static final long versionID=1L;

    public String login(String username,String password);
}
