package com.eric.netty;

import com.eric.netty.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动类
 *
 * @author EricShen
 * @date 2019-07-31
 */
@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NettyApplication.class, args);
        NettyClient nettyClient = context.getBean(NettyClient.class);
        nettyClient.run();
    }
}
