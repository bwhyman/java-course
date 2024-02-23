package com.example19.numbersstrings;

public class TextblockFormattedTest {
    public static void main(String[] args) {
        // textBlockTest();
        // stringFormatted();
    }

    private static void textBlockTest() {
        String json1 = "{\n" +
                      "\"name\" : \"BO\"" +
                      "\n}";
        System.out.println(json1);
        String json2 = """
                {
                  "name": "BO"
                }
                """;
        System.out.println(json2);
    }


    private static void stringFormatted() {
        String name = "BO";
        String address = "956";
        String clazz = "2班";
        String sex = "male";
        String str = "用户名：" + name + "；地址：" + address + "；班级：" + clazz + "；性别：" + sex + "。";
        System.out.println(str);

        String str2 = "用户名：%s；地址：%s；班级：%s；性别：%s。";
        String result = str2.formatted(name, address, clazz, sex);
        System.out.println(result);
        String str3 = "%s完成度为100%%";
        System.out.println(str3.formatted(clazz));
    }
}
