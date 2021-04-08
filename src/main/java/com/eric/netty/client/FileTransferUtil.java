package com.eric.netty.client;

import com.google.protobuf.ByteString;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * @author EricShen
 * @date 2019-08-02
 */
public class FileTransferUtil {

    public static ByteString fileToByteString(File source) throws IOException {
        return ByteString.copyFrom(FileUtils.readFileToByteArray(source));
    }

    public static File byteStringToFile(ByteString source, File target) throws IOException {
        FileUtils.writeByteArrayToFile(target, source.toByteArray());
        return target;
    }


}
