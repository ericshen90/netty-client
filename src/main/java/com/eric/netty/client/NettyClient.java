package com.eric.netty.client;

import com.eric.netty.protocol.protobuf.MessageBase;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 客户端
 *
 * @author EricShen
 * @date 2019-07-31
 */
@Slf4j
@Component
public class NettyClient {

    private EventLoopGroup group = new NioEventLoopGroup();

    private final static String HOST = "127.0.0.1";
    private final static int PORT = 9999;

    private static SocketChannel socketChannel;

    public void run() {
        try {
            doConnect(new Bootstrap(), group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Bootstrap doConnect(Bootstrap bootstrap, EventLoopGroup group) {
        log.info("开始连接Netty服务端");
        if (bootstrap != null) {
            bootstrap.group(group).channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.TCP_NODELAY, true)
                .handler(new ClientHandlerInitializer(this));
            bootstrap.remoteAddress(HOST, PORT);

            bootstrap.connect().addListener((ChannelFutureListener) future -> {
                final EventLoop eventLoop = future.channel().eventLoop();
                if (future.isSuccess()) {
                    log.info("连接Netty服务端成功");
                } else {
                    log.info("连接失败，进行5秒重连");
                    future.channel().eventLoop()
                        .schedule(() -> doConnect(new Bootstrap(), eventLoop), 5, TimeUnit.SECONDS);
                }
                socketChannel = (SocketChannel) future.channel();
            });

        }
        return bootstrap;
    }

    public static void sendMsg(MessageBase.Message message) {
        socketChannel.writeAndFlush(message);
    }
}
