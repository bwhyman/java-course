package com.example43.nio.channel;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Test {

    /**
     * 除异步非阻塞外，基于FileChannel可更安全的访问文件
     * 零拷贝技术。支持基于DMA在物理内存映射数据，增加读写速度，减少CPU占用
     * 无需关注读写位置
     * @throws IOException
     */
    private static void test() throws IOException {
        try (FileChannel in = FileChannel.open(Path.of("D:/in.txt"),
                StandardOpenOption.READ);
             FileChannel out = FileChannel.open(Path.of("D:/out.txt"),
                     StandardOpenOption.CREATE,
                     StandardOpenOption.WRITE)) {
            // 使用JVM内存
            ByteBuffer buffer = ByteBuffer.allocate(5);
            // 直接使用物理内存
            // ByteBuffer buffer = ByteBuffer.allocateDirect(5);
            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }
    }
}
