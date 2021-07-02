package com.example43.nio.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class Client {
    private static boolean run = true;
    private final int serverPort;

    public Client(int serverPort) throws Exception {
        this.serverPort = serverPort;
        init();
    }

    private void init() {
        try {
            SocketChannel client = SocketChannel.open();
            Selector selector = Selector.open();
            // 异步非阻塞
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            // 服务器端口
            client.connect(new InetSocketAddress("localhost", serverPort));
            client.finishConnect();
            new Thread(new ReadListener(selector)).start();
            Thread.sleep(1000);
            new Thread(new WriteListener(client)).start();

        } catch (IOException | InterruptedException e) {
            System.err.println("无法连接服务器");
            run = false;
        }
    }

    private static class ReadListener implements Runnable {

        private final ByteBuffer buffer = ByteBuffer.allocate(1024);
        private final byte[] data = new byte[buffer.capacity()];

        private final Selector selector;

        public ReadListener(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (run) {
                    if (selector.select() > 0) {
                        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            if (key.isReadable()) {
                                SocketChannel channel = (SocketChannel) key.channel();
                                buffer.clear();
                                channel.read(buffer);
                                buffer.flip();
                                // 获取消息体，即消息数据字节数组长度。占个4字节
                                int length = buffer.getInt();
                                // 将位置置于消息体数据开始的字节位置
                                buffer.position(4);
                                // 读取消息体数据
                                buffer.get(data, 0, length);
                                String msg = new String(data, 0, length);
                                System.out.println(msg);
                            }
                            // 事件处理后，必须手动移除
                            iterator.remove();
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("服务器端口连接");
                run = false;
            }
        }
    }

    private static class WriteListener implements Runnable {
        private final ByteBuffer buffer = ByteBuffer.allocate(1024);
        private final byte[] data = new byte[buffer.capacity()];
        private final SocketChannel channel;

        public WriteListener(SocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            try {
                while (run) {
                    System.out.println("输入发送到服务器的消息：");
                    Scanner scan = new Scanner(System.in);
                    if (scan.hasNextLine() && run) {
                        String str2 = scan.nextLine();
                        buffer.clear();
                        buffer.putInt(str2.getBytes().length);
                        buffer.put(str2.getBytes());
                        buffer.flip();
                        channel.write(buffer);
                    }
                }
            } catch (IOException e) {
                System.err.println("服务器端口连接");
                run = false;
            }
        }
    }
}
