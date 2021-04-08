package com.eric.netty.client;

import com.eric.netty.protocol.protobuf.CommandType.Command;
import com.eric.netty.protocol.protobuf.MessageBase;
import com.eric.netty.protocol.protobuf.MessageBase.Message;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * 验证
 *
 * @author EricShen
 * @date 2019-07-31
 */
@Slf4j
public class AuthHandler extends ChannelInboundHandlerAdapter {


    /**
     * 通道激活发送验证
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Message auth = Message.newBuilder().setCmd(Command.AUTH).setRequestId("12345")
            .setMsg("auth").build();
        log.info("通道激活,发送验证消息: {}", auth.toString());
        ctx.writeAndFlush(auth).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        ctx.fireChannelActive();
    }

    /**
     * 读取验证返回消息
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("验证返回：{}", msg.toString());
        if (msg instanceof MessageBase.Message) {
            Message message = (Message) msg;
            switch (message.getCmd()) {
                case AUTH_SUCCESS:
                    log.info("验证成功，移除 AuthHandler");
                    ctx.pipeline().remove(this);
                    return;
                case AUTH_FAIL:
                    log.info("验证失败，关闭通道");
                    ctx.channel().close();
                    return;
                default:
                    log.info("验证返回有误:{}==>{}", message.getCmd().toString(), message.getMsg());
                    ctx.channel().close();
                    return;
            }
        }
        log.info("返回消息格式有误");
    }

}
