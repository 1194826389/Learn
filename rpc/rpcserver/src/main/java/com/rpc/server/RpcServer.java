package com.rpc.server;

import com.rpc.annotation.RpcService;
import com.rpc.zookeeper.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.collections4.MapUtils.isNotEmpty;

/**
 * Created by hechao on 2017/7/27.
 */
public class RpcServer implements ApplicationContextAware,InitializingBean {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RpcServer.class);

    private String serverAddress;
    private ServiceRegistry serviceRegistry;

    //用于存储业务接口和实现类的实例对象(由spring所构造)
    public RpcServer(String serverAddress) {
        this.serverAddress = serverAddress;
    }


    //服务器绑定的地址和端口由spring在构造本类时从配置文件中传入
    public RpcServer(String serverAddress, ServiceRegistry serviceRegistry) {
        this.serverAddress = serverAddress;
        //用于向zookeeper注册名称服务的工具类
        this.serviceRegistry = serviceRegistry;
    }
    //用于存储业务接口和实现类的实例对象(由spring所构造)
    private Map<String, Object> handlerMap = new HashMap<String, Object>();


    /**
     * 通过注解，获取标注了rpc服务注解的业务类的----接口及impl对象，将它放到handlerMap中
     */
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Map<String,Object> serviceBeanMap = ctx.getBeansWithAnnotation(RpcService.class);
        if (isNotEmpty(serviceBeanMap)) {
            for (Object serviceBean : serviceBeanMap.values()) {
                //从业务实现类上的自定义注解中获取到value，从来获取到业务接口的全名
                String interfaceName = serviceBean.getClass().getAnnotation(RpcService.class).value().getName();
                handlerMap.put(interfaceName,serviceBean);
            }
        }

        LOGGER.info("handlerMap : {}",handlerMap);
    }

    public void afterPropertiesSet() throws Exception {
        String[] array = serverAddress.split(":");
        String host = array[0];
        int port = Integer.parseInt(array[1]);

        NettyServer nettyServer = new NettyServer();
        nettyServer.serviceRegistry = serviceRegistry;
        nettyServer.handlerMap = handlerMap;
        nettyServer.serverAddress = serverAddress;
        nettyServer.bind(host,port);
    }
}
