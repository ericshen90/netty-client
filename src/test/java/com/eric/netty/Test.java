package com.eric.netty;

import com.google.protobuf.ByteString;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * @author EricShen
 * @date 2019-08-02
 */
public class Test {

  public static void main(String[] args) throws IOException {
    // byte[] bytes = Files
    //     .readAllBytes(Paths.get("C:\\Users\\ahsbt\\Desktop\\Snipaste_2019-07-25_21-05-11.png"));
    File file = new File("C:\\Users\\ahsbt\\Desktop\\视联网存储网关_安装与管理说明书_v2.14.1_centos7.docx");
    byte[] bytes = FileUtils.readFileToByteArray(file);
    // FileUtils.writeByteArrayToFile(new File("file.docx"), bytes);
    ByteString byteString = ByteString.copyFrom(bytes);
    byte[] bytes1 = byteString.toByteArray();
    FileUtils.writeByteArrayToFile(new File("filexxxx.docx"), bytes1);
  }
}
