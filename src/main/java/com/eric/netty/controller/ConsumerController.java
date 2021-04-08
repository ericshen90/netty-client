package com.eric.netty.controller;

import com.google.protobuf.Any;
import com.eric.netty.client.FileTransferUtil;
import com.eric.netty.client.NettyClient;
import com.eric.netty.protocol.protobuf.CommandType.Command;
import com.eric.netty.protocol.protobuf.MessageBase;
import com.eric.netty.protocol.protobuf.ResultBase;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author EricShen
 * @date 2019-07-31
 */
@RestController
public class ConsumerController {

    @GetMapping("/send")
    public String send() throws IOException {
        File file = new File("C:\\Users\\ahsbt\\Desktop\\20140106170547843.png");

        MessageBase.Message message = MessageBase.Message.newBuilder().setCmd(Command.HIGH_PHOTO)
            .setMsg("hello server").setRequestId(UUID.randomUUID().toString()).setData(Any.pack(
                ResultBase.Result.newBuilder().setShaValue("")
                    .setFile(FileTransferUtil.fileToByteString(file)).build())).build();
        NettyClient.sendMsg(message);
        return "send ok";
    }
}
