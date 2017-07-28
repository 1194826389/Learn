package com.rpc.client;

import com.rpc.common.RpcRequest;
import com.rpc.common.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hechao on 2017/7/27.
 */
public class BusinessHandle extends SimpleChannelInboundHandler<RpcResponse> {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BusinessHandle.class);

    private RpcRequest request;

    private final RpcProxy proxy;

    public BusinessHandle(RpcRequest request,final RpcProxy proxy) {
        this.request = request;
        this.proxy = proxy;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("连接服务器成功--{}",request);
        ctx.writeAndFlush(request);

    }
    /**
     * 读取服务端的返回结果
     */
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponse msg) throws Exception {
        LOGGER.info("开始读取服务端的返回结果: {}",msg);

        proxy.respone = msg;
        synchronized (proxy) {
            proxy.notifyAll();
        }
        LOGGER.info("结束读取服务端的返回结果");
    }




    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.info("exceptionCaught");
        ctx.close();
    }


}
