package com.eric.netty;

import com.eric.netty.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 启动类
 *
 * @author EricShen
 * @date 2019-07-31
 */
@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
        NettyClient nettyClient = new NettyClient();
        nettyClient.run();
    }
}
