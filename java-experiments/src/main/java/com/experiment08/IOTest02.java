package com.experiment08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;

public class IOTest02 {
    public static void main(String[] args) {
        String fileName = "C:/example/from.txt";

        System.out.println("----- 创建文件 ------");
        // createFile(fileName);

        System.out.println("-----  将字符串写入文件 -------");
        // \r\n在txt文本中换行
        String str =
                "白日依山尽\r\n" +
                        "黄河入海流\r\n" +
                        "欲穷千里目\r\n" +
                        "更上一层楼\r\n";
        // writeToFile(fileName, str);
        writeToFile2(fileName, str);

        System.out.println("--------- 基于基本IO流实现文件的复制 ----------");
        String toFile = "C:/example/to.txt";
        // copyByIO(fileName, toFile);

        System.out.println("--------- 基于NIO实现文件的复制 ----------");
        String toFile2 = "C:/example/nio/to.txt";
        // copyByIO(fileName, toFile2);

        System.out.println("---------- 删除绝对路径的指定文件 -------------");
        // deleteFile(toFile);

        System.out.println("---------- 遍历指定目录文件 -------------");
        String dir = "C:/example";
        walkDirectories(dir);
    }

    /**
     * 基于Path/Files实现
     * 将传入的文件绝对路径字符串转path
     * 判断path不存在，则先创建目录，创建文件
     * 文件存在，忽略操作
     *
     * @param fileName
     */
    private static void createFile(String fileName) {
        try {
            Path fileP = Path.of(fileName);
            if (Files.notExists(fileP)) {
                Files.createDirectories(fileP.getParent());
                Files.createFile(fileP);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注意，传入的fileName为文件绝对路径，必须确保文件所在目录已经存在，才能通过FileOutputStream创建
     * 将字符串转字节数组，基于FileOutputStream直接写入
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile(String fileName, String content) {
        // fileName文件所在目录必须存在才能output创建文件
        try (FileOutputStream os = new FileOutputStream(fileName)) {
            os.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将传入的文件绝对路径字符串转path，通过Files创建文件所在目录
     * 将字符串，基于Files工具类直接写入。写入方法，文件不存在创建并写入，存在则覆盖写入
     * 字符串转字节数组再写入也可，但无意义
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile2(String fileName, String content) {
        try {
            Path fileP = Path.of(fileName);
            Files.createDirectories(fileP.getParent());
            Files.writeString(fileP, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于基本IO，以及字节数组缓冲区，复制文件
     * 正确关闭资源
     * 打印显示循环读写循环次数
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByIO(String sourceFile, String targetFile) {
        try(FileInputStream is = new FileInputStream(sourceFile);
        FileOutputStream os = new FileOutputStream(targetFile)) {
           byte[] buffer = new byte[512];
           int len = 0;
           while ((len = is.read(buffer)) != -1) {
               os.write(buffer, 0, len);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于NIO，实现文件的复制。目标文件存在则覆盖
     * 注意，判断目标为字符串，需要转为path并创建相应目录
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByNIO(String sourceFile, String targetFile) {
        try {
            Path sourceP = Path.of(sourceFile);
            // 卫式编程，避免Nesting hell
            if (Files.notExists(sourceP)) {
                throw new RuntimeException("源文件不存在");
            };
            Path targetP = Path.of(targetFile);
            Files.createDirectories(targetP.getParent());
            Files.copy(sourceP, targetP, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    private static void deleteFile(String fileName) {
        try {
            Files.deleteIfExists(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历打印指定目录下全部目录/文件名称
     * 尝试改变正逆序操作方法
     *
     * @param dir
     */
    private static void walkDirectories(String dir) {
        try {
            Files.walk(Path.of(dir))
                    .forEach(System.out::println);
            System.out.println("--- reversed ---");
            Files.walk(Path.of(dir))
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
