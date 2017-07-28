package com.rpc.server;

import com.rpc.common.RpcRequest;
import com.rpc.common.RpcResponse;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by hechao on 2017/7/27.
 */
public class RpcHandler extends SimpleChannelInboundHandler<RpcRequest> {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RpcHandler.class);
    private final Map<String, Object> handlerMap;


    public RpcHandler(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequest request) throws Exception {
        LOGGER.info("服务器开始读取客户端发来的信息");
        RpcResponse response = new RpcResponse();
        response.setRequestId(request.getRequestId());
        try {
            Object result = handle(request);
            response.setResult(result);
        } catch (Throwable t) {
            response.setError(t);
        }


        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        LOGGER.info("服务器结束读取客户端发来的信息");
    }

    private Object handle(RpcRequest request) throws Throwable {
        // 从客户端发过的请求里拿出类名
        String className = request.getClassName();

        // 在handlerMap中根据类名拿到实现类对象
        Object serviceBean = handlerMap.get(className);

        // 从客户端发过的请求拿到要调用的方法名，参数类型，参数值
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] parameters = request.getParameters();

        // 拿到接口类
        Class<?> clazz = Class.forName(className);

        Method method = clazz.getMethod(methodName,parameterTypes);
        return method.invoke(serviceBean,parameters);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.info("exceptionCaught");

        LOGGER.info(String.valueOf(cause));
        ctx.close();
    }
}
