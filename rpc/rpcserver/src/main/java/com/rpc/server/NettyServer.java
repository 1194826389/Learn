package com.rpc.server;

import com.rpc.common.RpcDecoder;
import com.rpc.common.RpcEncoder;
import com.rpc.common.RpcRequest;
import com.rpc.common.RpcResponse;
import com.rpc.zookeeper.ServiceRegistry;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by hechao on 2017/7/27.
 */
public class NettyServer {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(NettyServer.class);


    public Map<String, Object> handlerMap;
    public ServiceRegistry serviceRegistry;
    public String serverAddress;


    public void bind(String host, int port) throws Exception{

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline()
                                    .addLast(new RpcDecoder(RpcRequest.class)) // 注册解码 IN-1
                                    .addLast(new RpcEncoder(RpcResponse.class)) // 注册编码 OUT
                                    .addLast(new RpcHandler(handlerMap)); //注册RpcHandler IN-2
                        }
                    });
            ChannelFuture f = serverBootstrap.bind(host,port).sync();
            LOGGER.info("server started on port {}",port);
            if (serviceRegistry != null) {
                serviceRegistry.register(serverAddress);
            }

            f.channel().closeFuture().sync();
        } finally {
            LOGGER.info("NettyServer shutdown");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
