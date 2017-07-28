package com.rpc.client;

import com.rpc.common.RpcRequest;
import com.rpc.common.RpcResponse;
import com.rpc.zookeeper.ServiceDiscovery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * Created by hechao on 2017/7/27.
 */
public class RpcProxy {
    private String serverAddress;
    private ServiceDiscovery serviceDiscovery;
    RpcResponse respone = null;
    public RpcProxy(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public RpcProxy(ServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    @SuppressWarnings("unchecked")
    public <T> T create(Class<?> interfaceClass) {
        return  (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        RpcRequest request = new RpcRequest();
                        request.setRequestId(UUID.randomUUID().toString());
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);

                        if (serviceDiscovery != null) {
                            serverAddress = serviceDiscovery.discover();
                        }
                        String[] array = serverAddress.split(":");
                        String host = array[0];
                        int port = Integer.parseInt(array[1]);

                        NettyClient client = null;


                        client = new NettyClient();
                        client.request = request;
                        client.connect(host,port,RpcProxy.this);

                        synchronized (RpcProxy.this) {
                            while (respone == null) {
                                RpcProxy.this.wait();
                            }
                        }

                        if (respone.isError()) {
                            throw respone.getError();
                        } else {
                            return respone.getResult();
                        }

                    }
                });

    }

}
