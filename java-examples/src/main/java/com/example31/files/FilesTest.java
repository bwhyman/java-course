package com.example31.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.stream.Stream;

public class FilesTest {


    public static void main(String[] args) throws IOException {
        //getPath();
        // checkPath();
        // walk();
        //walk2();
        deleteDirectory();
    }

    private static void getPath() {
        Path p = Path.of("D:/test/input.txt");

        System.out.println(p.getClass().getName());

        System.out.println(p);
        System.out.println(p.getFileName());
        System.out.println(p.getParent());
        System.out.println(p.getRoot());
    }

    private static void getJoinPaths() {
        Path dir = Path.of("D:/test");
        Path file = Path.of("input.txt");
        Path p1 = dir.resolve(file);
        System.out.println(p1);

        Path p2 = Path.of("D:/test/input.txt");
        System.out.println(p1.equals(p2));

        Path p3 = Path.of("D:", "test", "input.txt");
        System.out.println(p1.equals(p3));
    }

    /**
     * 必须基于resolve()方法，拼接路径。否则可能出现错误
     */
    private static void getJoinPaths2() {
        Path base = Path.of("D:/test");
        Path file = Path.of("input.txt");
        System.out.println(base.toString());
        System.out.println(file.toString());
        System.out.println(base.toString() + file.toString());
        System.out.println(base.resolve(file));
    }

    private static final Path BASE_PATH = Path.of("D:/test");

    private static void checkPath() {
        Path p = BASE_PATH.resolve("aaaaa");
        System.out.println(Files.exists(p));
        System.out.println("目录：" + Files.isDirectory(p));

        System.out.println(Files.exists(BASE_PATH));
        System.out.println("目录：" + Files.isDirectory(BASE_PATH));

        Path p2 = BASE_PATH.resolve("input.txt");
        System.out.println(Files.exists(p2));
        System.out.println("目录：" + Files.isDirectory(p2));
    }

    /**
     * 直接创建多级目录
     *
     * @throws IOException
     */
    private static void createDirectory() throws IOException {
        Path dir = Path.of("D:/test/a/b/c");
        Files.createDirectories(dir);
    }

    /**
     * 在base/a目录，创建a.txt文件
     *
     * @throws IOException
     */
    private static void createFile() throws IOException {
        Path file = Path.of("D:/test/a/a.txt");
        Files.createDirectories(file.getParent());
        Files.createFile(file);

    }


    private static void copy() throws IOException {
        Path source = BASE_PATH.resolve("input.txt");
        Path target = BASE_PATH.resolve("output.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void move() throws IOException {
        Path source = BASE_PATH.resolve("input.txt");
        Path target = Path.of("D:/test/a/output.txt");
        // 目标目录可能不存在
        Files.createDirectories(target.getParent());
        Files.move(source, target);
    }

    private static void delete() throws IOException {
        // 目录不为空，默认无法直接删除目录
        Path dir = Path.of("D:/test");
        Files.deleteIfExists(dir);

        Path path = BASE_PATH.resolve("input.txt");
        Files.deleteIfExists(path);

    }

    private static void walk() throws IOException {
        Path dir = Path.of("D:/test");
        try (Stream<Path> walk = Files.walk(dir);
             Stream<Path> walkDepth = Files.walk(dir, 1)) {
            walk.forEach(System.out::println);
            System.out.println("---------");
            walkDepth.forEach(System.out::println);
        }
    }

    /**
     * 删除指定目录路径下的，指定文件
     */
    private static void walk2() throws IOException {
        Path file = Path.of("a.txt");

        try (Stream<Path> walk = Files.walk(BASE_PATH)) {
            walk.filter(p -> p.getFileName().equals(file))
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    /**
     * 删除base目录，及全部子目录及文件
     * 必须按，先文件，后目录的倒序删除
     *
     * @throws IOException
     */
    private static void deleteDirectory() throws IOException {
        try (Stream<Path> walk = Files.walk(BASE_PATH)) {
            walk.sorted(Comparator.reverseOrder())
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }


    private static void readBytes() throws IOException {
        Path file = Path.of("D:/test/input.txt");
        byte[] bs = Files.readAllBytes(file);
        System.out.println(new String(bs));

    }

    private static void copyByInputStream() throws IOException {
        InputStream in = new FileInputStream("D:/test/input.txt");
        Files.copy(in, Path.of("D:/test/a.txt"));
    }

    private static void readString() throws IOException {
        String result = Files.readString(Path.of("D:/test/input.txt"));
        System.out.println(result);
    }
}
