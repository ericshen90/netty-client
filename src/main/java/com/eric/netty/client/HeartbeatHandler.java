package com.eric.netty.client;

import com.eric.netty.protocol.protobuf.CommandType.Command;
import com.eric.netty.protocol.protobuf.MessageBase.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

/**
 * 心跳
 *
 * @author EricShen
 * @date 2019-07-31
 */
@Slf4j
public class HeartbeatHandler extends ChannelInboundHandlerAdapter {

    private NettyClient nettyClient;

    public HeartbeatHandler(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                log.info("10s空闲发送消息给服务端");
                Message heartbeat = Message.newBuilder().setCmd(Command.PING)
                    .setRequestId(UUID.randomUUID().toString()).setMsg("heartbeat").build();
                //发送心跳消息，并在发送失败时关闭该连接
                ctx.writeAndFlush(heartbeat).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Message) {
            if (((Message) msg).getCmd().equals(Command.PONG)) {
                log.info("服务端心跳回应: {}", msg.toString());
                return;
            }
        }
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //如果运行过程中服务端挂了,执行重连机制
        log.info("服务断开重连");
        final EventLoop eventLoop = ctx.channel().eventLoop();
        nettyClient.doConnect(new Bootstrap(), eventLoop);
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("心跳捕获的异常：{}", cause.getMessage());
        final EventLoop eventLoop = ctx.channel().eventLoop();
        nettyClient.doConnect(new Bootstrap(), eventLoop);
        ctx.channel().close();
    }
}
