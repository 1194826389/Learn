package com.learn.hadoop.RPC.service;

import com.learn.hadoop.RPC.protocol.ClientNameNodeProtocol;

/**
 * Created by hechao on 2017/8/1.
 */
public class NameNodeSystem implements ClientNameNodeProtocol {
    @Override
    public String getMetaData(String path) {

        return path+"[blk_01,blk_02,blk_03]\n{blk_01:node01,node02}";

    }
}
