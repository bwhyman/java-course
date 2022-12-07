package com.example34.java17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ToSQLScript {

    public static void main(String[] args) throws IOException {
        // generate2();
    }

    /**
     * Java17
     *
     * @throws IOException
     */
    private static void generate2() throws IOException {
        List<String> numbers = Files.readAllLines(Path.of("D:/stus.txt"));
        StringBuilder builder = new StringBuilder();
        var userSt = """
                create user if not exists '%s'@'%%' identified by '%s';
                """;
        var databaseSt = """
                create database if not exists `%s`;
                """;
        var privilegesSt = """
                grant all privileges on `%s`.* to '%s'@'%%' with grant option;
                """;
        numbers.forEach(number -> {
            builder.append(userSt.formatted(number, number));
            builder.append(databaseSt.formatted(number));
            builder.append(privilegesSt.formatted(number, number));
        });
        builder.append("flush privileges;");
        Files.writeString(Path.of("D:/result.sql"), builder.toString());
    }

    private static void generate() throws IOException {
        List<String> numbers = Files.readAllLines(Path.of("D:/stus.txt"));
        StringBuilder builder = new StringBuilder();
        numbers.forEach(n -> {
            builder.append("create user if not exists '");
            builder.append(n);
            builder.append("'@'%' identified by '");
            builder.append(n);
            builder.append("';");
            builder.append("\n");
            builder.append("create database if not exists `");
            builder.append(n);
            builder.append("`;");
            builder.append("\n");
            builder.append("grant all privileges on `");
            builder.append(n);
            builder.append("`.* to '");
            builder.append(n);
            builder.append("'@'%' with grant option;");
            builder.append("\n");
        });
        builder.append("flush privileges;");
        Files.writeString(Path.of("D:/result.sql"), builder.toString());
    }
}
