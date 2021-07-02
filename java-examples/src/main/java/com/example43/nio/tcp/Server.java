package com.example43.nio.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {

    public static void main(String[] args) throws IOException {
        // TCP端口
        final int port = 18844;
        final byte[] welcomeMsg = "欢迎访问".getBytes();
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        final byte[] data = new byte[buffer.capacity()];
        // 客户端连接集合
        final List<SocketChannel> clients = new ArrayList<>();

        final ServerSocketChannel serverChannel = ServerSocketChannel.open();
        final Selector selector = Selector.open();
        // 监听端口
        serverChannel.bind(new InetSocketAddress(port));
        // 异步非阻塞
        serverChannel.configureBlocking(false);
        // 服务器通道监听的事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            if (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SocketChannel channel = null;
                    SelectionKey key = iterator.next();
                    try {
                        if (key.isAcceptable()) {
                            // 有连接进入
                            channel = serverChannel.accept();
                            if (channel != null) {
                                System.out.println("有客户端进入");
                                channel.configureBlocking(false);
                                channel.register(selector, SelectionKey.OP_READ);
                                // 发送自定义消息头。包含消息体长度
                                buffer.clear();
                                buffer.putInt(welcomeMsg.length);
                                buffer.put(welcomeMsg);
                                buffer.flip();
                                channel.write(buffer);
                                clients.add(channel);
                            }
                        }

                        if (key.isReadable()) {
                            channel = (SocketChannel) key.channel();
                            buffer.clear();
                            channel.read(buffer);
                            buffer.flip();
                            int length = buffer.getInt();
                            buffer.position(4);
                            buffer.get(data, 0, length);
                            String msg = new String(data, 0, length);
                            String remoteAddress = channel.getRemoteAddress().toString();
                            msg = remoteAddress + ": " + msg;
                            buffer.clear();
                            buffer.putInt(msg.getBytes().length);
                            buffer.put(msg.getBytes());
                            buffer.flip();
                            for (SocketChannel client : clients) {
                                // 向处自己外的其他客户端发送消息
                                if (client != channel) {
                                    client.write(buffer);
                                }
                            }
                        }
                        iterator.remove();
                    } catch (Exception e) {
                        System.err.println("客户端断开连接");
                        if (channel != null) {
                            channel.close();
                            clients.remove(channel);
                            key.channel();
                        }
                    }
                }
            }
        }
    }
}
