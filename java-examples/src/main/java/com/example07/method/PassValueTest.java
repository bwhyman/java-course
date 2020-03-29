package com.example07.method;


public class PassValueTest {
    public static void main(String[] args) {

        String n = "Java";
        int i = 10;
        getPrimitiveData(n, i);
        System.out.println("local variable name: "+ n);
        System.out.println("local variable index: " + i);

        System.out.println("--------Passing Reference Data Type Arguments--------");
        Bicycle bicycle = new Bicycle(5);
        getReferenceData(bicycle);
        System.out.println("After the method called: " + bicycle.getGear());
    }

    /**
     * 8+1基本数据类型的值传递
     * @param name
     * @param index
     */
    private static void getPrimitiveData(String name, int index) {
        System.out.println("arg name: " + name);
        System.out.println("arg index: " + index);
        name = "C++";
        index = 5;
        System.out.println("new name: " + name);
        System.out.println("new index: " + index);
    }

    /**
     * 对象的引用传递给方法
     * @param bicycle
     */
    private static void getReferenceData(Bicycle bicycle) {
        System.out.println("grear in method: " + bicycle.getGear());
        bicycle.setGear(2);
        System.out.println("grear after changed in method: " + bicycle.getGear());
    }
    /**
     * 可变长度的参数
     * @param names
     */
    private static void getArbitraryNumber(String... names) {
        for (String s : names) {
            System.out.println(s);
        }
    }
}
