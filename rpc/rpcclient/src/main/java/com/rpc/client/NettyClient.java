package com.rpc.client;

import com.rpc.common.RpcDecoder;
import com.rpc.common.RpcEncoder;
import com.rpc.common.RpcRequest;
import com.rpc.common.RpcResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hechao on 2017/7/27.
 */
public class NettyClient {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(NettyClient.class);


//
//    private RpcResponse response = null;
//
    public RpcRequest request;

    public NettyClient() {

    }


    public void connect(String host, final int port, final RpcProxy proxy) throws Exception{

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline p = channel.pipeline();
                            p.addLast(new RpcEncoder(RpcRequest.class)); // OUT - 1
                            p.addLast(new RpcDecoder(RpcResponse.class)); // IN - 1
                            p.addLast(new BusinessHandle(request,proxy)); // IN - 2
                        }
                    }).option(ChannelOption.SO_KEEPALIVE,true);
            LOGGER.info("开启netty服务的host:{}  - port:{}",host,port);
            ChannelFuture f = bootstrap.connect(host,port).sync();

            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}
