package com.eric.netty.client;

import com.eric.netty.protocol.protobuf.CommandType.Command;
import com.eric.netty.protocol.protobuf.MessageBase;
import com.eric.netty.protocol.protobuf.ResultBase.Result;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 业务
 *
 * @author EricShen
 * @date 2019-07-31
 */
@ChannelHandler.Sharable
@Slf4j
public class NettyClientHandler extends SimpleChannelInboundHandler<MessageBase.Message> {

    /**
     * 如果服务端发生消息给客户端，下面方法进行接收消息
     *
     * @param ctx
     * @param msg
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageBase.Message msg)
        throws Exception {
        log.info("客户端收到消息：{}", msg.toString());
        Result unpack = msg.getData().unpack(Result.class);
        log.info("解包后消息：{}", unpack.toString());
    }

    /**
     * 处理异常, 一般将实现异常处理逻辑的Handler放在ChannelPipeline的最后 这样确保所有入站消息都总是被处理，无论它们发生在什么位置，下面只是简单的关闭Channel并打印异常信息
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
