// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Command.proto

package com.eric.netty.protocol.protobuf;

public final class CommandType {
  private CommandType() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code Command}
   */
  public enum Command
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     *验证请求
     * </pre>
     *
     * <code>AUTH = 0;</code>
     */
    AUTH(0),
    /**
     * <pre>
     *验证成功
     * </pre>
     *
     * <code>AUTH_SUCCESS = 1;</code>
     */
    AUTH_SUCCESS(1),
    /**
     * <pre>
     *验证失败
     * </pre>
     *
     * <code>AUTH_FAIL = 2;</code>
     */
    AUTH_FAIL(2),
    /**
     * <pre>
     *客户端心跳消息
     * </pre>
     *
     * <code>PING = 10;</code>
     */
    PING(10),
    /**
     * <pre>
     *服务端心跳消息
     * </pre>
     *
     * <code>PONG = 11;</code>
     */
    PONG(11),
    /**
     * <pre>
     *系统配置
     * </pre>
     *
     * <code>SYS_CONFIG = 100;</code>
     */
    SYS_CONFIG(100),
    /**
     * <pre>
     *更新补丁
     * </pre>
     *
     * <code>PATCH_UPDATE = 101;</code>
     */
    PATCH_UPDATE(101),
    /**
     * <pre>
     *高拍仪
     * </pre>
     *
     * <code>HIGH_PHOTO = 201;</code>
     */
    HIGH_PHOTO(201),
    /**
     * <pre>
     *身份证读取
     * </pre>
     *
     * <code>ID_CARD = 202;</code>
     */
    ID_CARD(202),
    /**
     * <pre>
     *签名板
     * </pre>
     *
     * <code>SIGNATURE = 203;</code>
     */
    SIGNATURE(203),
    /**
     * <pre>
     *业务打印
     * </pre>
     *
     * <code>BUSINESS_PRINTER = 204;</code>
     */
    BUSINESS_PRINTER(204),
    /**
     * <pre>
     *叫号机打印
     * </pre>
     *
     * <code>QUEUE_PRINTER = 205;</code>
     */
    QUEUE_PRINTER(205),
    /**
     * <pre>
     *人脸识别
     * </pre>
     *
     * <code>FACE_REC = 206;</code>
     */
    FACE_REC(206),
    /**
     * <pre>
     *指纹
     * </pre>
     *
     * <code>FINGERPRINT = 207;</code>
     */
    FINGERPRINT(207),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     *验证请求
     * </pre>
     *
     * <code>AUTH = 0;</code>
     */
    public static final int AUTH_VALUE = 0;
    /**
     * <pre>
     *验证成功
     * </pre>
     *
     * <code>AUTH_SUCCESS = 1;</code>
     */
    public static final int AUTH_SUCCESS_VALUE = 1;
    /**
     * <pre>
     *验证失败
     * </pre>
     *
     * <code>AUTH_FAIL = 2;</code>
     */
    public static final int AUTH_FAIL_VALUE = 2;
    /**
     * <pre>
     *客户端心跳消息
     * </pre>
     *
     * <code>PING = 10;</code>
     */
    public static final int PING_VALUE = 10;
    /**
     * <pre>
     *服务端心跳消息
     * </pre>
     *
     * <code>PONG = 11;</code>
     */
    public static final int PONG_VALUE = 11;
    /**
     * <pre>
     *系统配置
     * </pre>
     *
     * <code>SYS_CONFIG = 100;</code>
     */
    public static final int SYS_CONFIG_VALUE = 100;
    /**
     * <pre>
     *更新补丁
     * </pre>
     *
     * <code>PATCH_UPDATE = 101;</code>
     */
    public static final int PATCH_UPDATE_VALUE = 101;
    /**
     * <pre>
     *高拍仪
     * </pre>
     *
     * <code>HIGH_PHOTO = 201;</code>
     */
    public static final int HIGH_PHOTO_VALUE = 201;
    /**
     * <pre>
     *身份证读取
     * </pre>
     *
     * <code>ID_CARD = 202;</code>
     */
    public static final int ID_CARD_VALUE = 202;
    /**
     * <pre>
     *签名板
     * </pre>
     *
     * <code>SIGNATURE = 203;</code>
     */
    public static final int SIGNATURE_VALUE = 203;
    /**
     * <pre>
     *业务打印
     * </pre>
     *
     * <code>BUSINESS_PRINTER = 204;</code>
     */
    public static final int BUSINESS_PRINTER_VALUE = 204;
    /**
     * <pre>
     *叫号机打印
     * </pre>
     *
     * <code>QUEUE_PRINTER = 205;</code>
     */
    public static final int QUEUE_PRINTER_VALUE = 205;
    /**
     * <pre>
     *人脸识别
     * </pre>
     *
     * <code>FACE_REC = 206;</code>
     */
    public static final int FACE_REC_VALUE = 206;
    /**
     * <pre>
     *指纹
     * </pre>
     *
     * <code>FINGERPRINT = 207;</code>
     */
    public static final int FINGERPRINT_VALUE = 207;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static Command valueOf(int value) {
      return forNumber(value);
    }

    public static Command forNumber(int value) {
      switch (value) {
        case 0: return AUTH;
        case 1: return AUTH_SUCCESS;
        case 2: return AUTH_FAIL;
        case 10: return PING;
        case 11: return PONG;
        case 100: return SYS_CONFIG;
        case 101: return PATCH_UPDATE;
        case 201: return HIGH_PHOTO;
        case 202: return ID_CARD;
        case 203: return SIGNATURE;
        case 204: return BUSINESS_PRINTER;
        case 205: return QUEUE_PRINTER;
        case 206: return FACE_REC;
        case 207: return FINGERPRINT;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Command>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Command> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Command>() {
            public Command findValueByNumber(int number) {
              return Command.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return CommandType.getDescriptor().getEnumTypes().get(0);
    }

    private static final Command[] VALUES = values();

    public static Command valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Command(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:Command)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rCommand.proto*\345\001\n\007Command\022\010\n\004AUTH\020\000\022\020\n" +
      "\014AUTH_SUCCESS\020\001\022\r\n\tAUTH_FAIL\020\002\022\010\n\004PING\020\n" +
      "\022\010\n\004PONG\020\013\022\016\n\nSYS_CONFIG\020d\022\020\n\014PATCH_UPDA" +
      "TE\020e\022\017\n\nHIGH_PHOTO\020\311\001\022\014\n\007ID_CARD\020\312\001\022\016\n\tS" +
      "IGNATURE\020\313\001\022\025\n\020BUSINESS_PRINTER\020\314\001\022\022\n\rQU" +
      "EUE_PRINTER\020\315\001\022\r\n\010FACE_REC\020\316\001\022\020\n\013FINGERP" +
      "RINT\020\317\001B/\n com.eric.netty.protocol.proto" +
      "bufB\013CommandTypeb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
