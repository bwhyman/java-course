package com.example34.java17;

import java.util.List;

public class Java17NewFeaturesTest {

    public static void main(String[] args) {

    }

    /**
     * switch，支持无需公共变量直接返回值；箭头函数无需break；yield声明局部返回值
     */
    private static void getSwitch(int number) {
        String result = switch (number) {
            case 1 -> "test1";
            case 2 -> "test2";
            case 3, 4 -> "test3";
            default -> "default";
        };

        String result2 = switch (number) {
            case 1:
                yield "test1";
            case 2: {
                yield "test2";
            }
            default:
                yield "default";
        };
    }

    /**
     * text blocks，终于无需+号拼接
     * formatted()方法，since java15，支持类似format()的占位符，但仍不支持类似JS的直接引入外部变量
     */
    private static void getTextBlock() {
        String str = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                </head>
                <body>
                Hello World
                </body>
                </html>
                """;

        String name = "BO";
        String role = "admin";
        String str2 = """
                username: %s and authority: %s
                """.formatted(name, role);
    }


    private static record Student(String name, int number) {
    }

    ;

    /**
     * record声明对象属性值必为final的类
     * 但业务逻辑/AOP切面等仍需修改属性数据，使用场景有限
     */
    private static void getRecord() {
        Student s1 = new Student("BO", 2046);
        System.out.println(s1.name + "/" + s1.name);
        // 可直接声明
        record Teacher(String name, Student student) {
        }
        ;
        Teacher t = new Teacher("BO", s1);
        System.out.println(t.student.name);
    }

    /**
     * Stream toList()方法支持直接聚合为List集合；但仍不支持直接聚合为Set/Map等
     */
    private static void getToList() {
        List<String> target = List.of("apple", "banana", "orange");
        target.stream()
                .filter(t -> t.length() > 4)
                .toList()
                .forEach(System.out::println);
    }
}
