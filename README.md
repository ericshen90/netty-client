[中文版](./README_CN.md)

# Netty-Client-Demo

A Netty-based client implementation integrated with Spring Boot, featuring Google Protobuf serialization, heartbeat mechanism, automatic reconnection, and authentication.

## 📋 Table of Contents
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Quick Start](#quick-start)
- [Detailed Design](#detailed-design)
  - [1. Netty Client Configuration](#1-netty-client-configuration)
  - [2. Protobuf Communication](#2-protobuf-communication)
  - [3. Heartbeat & Idle Detection](#3-heartbeat--idle-detection)
  - [4. Reconnection Strategy](#4-reconnection-strategy)
  - [5. Authentication Handshake](#5-authentication-handshake)
- [Testing](#testing)
- [Reference](#reference)

---

## ✨ Features
- **Spring Boot Integration**: Easy to manage and deploy.
- **Protobuf Serialization**: High-performance, cross-language binary protocol.
- **Heartbeat Mechanism**: Ensures connection liveness.
- **Auto Reconnect**: Robustness against network instability or server restarts.
- **Authentication**: Initial handshake to secure the connection.
- **Generic Message Wrapper**: Flexible communication protocol using `google.protobuf.Any`.

## 🛠 Technology Stack
- **Java**: 21
- **Spring Boot**: 3.3.0
- **Netty**: 4.1.110.Final
- **Google Protobuf**: 3.25.3
- **Lombok**: Simplifies boilerplate code.

## 📂 Project Structure
```text
src/main/java/com/eric/netty/
├── NettyApplication.java          # Application Entry Point
├── client/
│   ├── AuthHandler.java           # Security handshake
│   ├── ClientHandlerInitializer.java # Pipeline setup
│   ├── FileTransferUtil.java      # File-to-ByteString utility
│   ├── HeartbeatHandler.java      # Heartbeat and reconnection logic
│   ├── NettyClient.java           # Client bootstrap
│   └── NettyClientHandler.java    # Business logic processing
├── controller/
│   └── ConsumerController.java    # HTTP endpoint for manual testing
└── protocol/
    └── protobuf/                  # Protocol definitions and generated classes
```

## 🚀 Quick Start

### Prerequisites
- JDK 21+
- Maven 3.x
- A running Netty Server (Expected at `127.0.0.1:9999`)

### Installation & Running
1. **Clone the project**
2. **Build with Maven**:
   ```bash
   mvn clean install
   ```
3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

## 📖 Detailed Design

### 1. Netty Client Configuration
The client is initialized as a Spring `@Component`. It uses `NioEventLoopGroup` and `NioSocketChannel` for non-blocking I/O.

### 2. Protobuf Communication
The project uses Google Protocol Buffers for structured data serialization.
- **Definition**: Messages are defined in `.proto` files in `src/main/java/com/eric/netty/protocol/protobuf/`.
- **Pipeline**:
  - `ProtobufVarint32FrameDecoder`: Handles TCP fragmentation.
  - `ProtobufDecoder`: Decodes bytes into `MessageBase.Message`.
  - `ProtobufVarint32LengthFieldPrepender`: Adds length prefix to outgoing messages.
  - `ProtobufEncoder`: Encodes `MessageBase.Message` into bytes.

### 3. Heartbeat & Idle Detection
- **IdleStateHandler**: Configured to trigger a `WRITER_IDLE` event after 10 seconds of inactivity.
- **HeartbeatHandler**: Listens for the idle event and sends a `PING` command to the server. It also handles `PONG` responses.

### 4. Reconnection Strategy
The client implements a dual-layer reconnection strategy:
- **Connection Failure**: If `bootstrap.connect()` fails, a retry is scheduled after 5 seconds.
- **Connection Lost**: If the channel becomes inactive (`channelInactive`) or an exception occurs, the client attempts to reconnect.

### 5. Authentication Handshake
Upon successful TCP connection, `AuthHandler` sends an `AUTH` command.
- If the server returns `AUTH_SUCCESS`, the `AuthHandler` is removed from the pipeline, allowing business traffic.
- If `AUTH_FAIL` is received, the connection is closed.

## 🧪 Testing
A `ConsumerController` is provided to trigger message sending via HTTP:
```bash
curl http://localhost:7777/send
```
> **Note**: The `/send` endpoint triggers a message send using a dummy file for demonstration purposes.

## 📚 Reference
- [Netty Documentation](https://netty.io/)
- [Protobuf Guide](https://developers.google.com/protocol-buffers)
