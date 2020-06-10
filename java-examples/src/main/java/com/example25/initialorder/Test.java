package com.example25.initialorder;

public class Test {

    public static void main(String[] args) {
        //A.getS();
        // A.getS();
        //new A();
        new B();
        //B.getB();
       // new C(new A());
    }

    /**
     * 调用1次A.get()方法
     * 调用2次A.get()方法
     * 类A，头尾添加static块
     * 类A，static块调整顺序
     *
     * 类A，追加构造函数，调用A.get()方法
     * 创建类A对象
     *
     * 创建类B对象
     * 调用B.getB()方法
     *
     * 创建类C对象
     * 类C中属性A，创建初始化对象
     */

}
