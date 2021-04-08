package com.eric.netty.client;

import com.eric.netty.protocol.protobuf.MessageBase;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 初始化
 *
 * @author EricShen
 * @date 2019-07-31
 */
@Slf4j
public class ClientHandlerInitializer extends ChannelInitializer<Channel> {

    private NettyClient nettyClient;

    public ClientHandlerInitializer(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

    @Override
    protected void initChannel(Channel ch) {
        ch.pipeline().addLast(new IdleStateHandler(0, 10, 0))
            .addLast(new ProtobufVarint32FrameDecoder())
            .addLast(new ProtobufDecoder(MessageBase.Message.getDefaultInstance()))
            .addLast(new ProtobufVarint32LengthFieldPrepender())
            .addLast(new ProtobufEncoder())
            .addLast(new AuthHandler())
            .addLast(new HeartbeatHandler(nettyClient))
            .addLast(new NettyClientHandler());
    }
}
