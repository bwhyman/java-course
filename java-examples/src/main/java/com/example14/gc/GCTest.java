package com.example14.gc;



public class GCTest {
    public static void main(String[] args) {
        // 这个工具箱的保存地址，被传递给别人继续使用
        ToolBox toolBox = testCreateToolBox2();
    }

    private static void testCreateToolBox() {
        // 创建了一个放钳子的工具箱
        // 并创建一个标签(变量)tb，上面写着这个工具箱的存放位置
        // 即，任何人都可以通过标签tb，找到这个工具箱
        ToolBox tb = new ToolBox("钳子");
        // 通过标签tb找到工具箱并使用
        tb.work();
    }
    // 当方法结束，方法中的局部变量被销毁
    // 即，存放工具箱的标签tb被销毁
    // 即没人再知道这个工具箱的位置
    // 则，系统认定，没人知道这个工具箱的存在，则需要被回收销毁


    private static ToolBox testCreateToolBox2() {
        ToolBox tb = new ToolBox("钳子");
        // 通过标签tb找到工具箱并使用
        tb.work();
        return tb;
    }
    // 方法将标签tb上写着的工具箱的位置传给方法调用者
    // 方法结束，标签tb销毁，但其记录的工具箱位置已经被传递给调用者
    // 即，调用者也知道这个工具箱的位置
    // 则，系统认定，还有人知道这个工具箱的存在，这个工具箱还会被使用，则不会被回收销毁


    private static void testCreateToolBox3() {
        ToolBox tb = new ToolBox("钳子");
        tb.work();
        ToolBox tb2 = new ToolBox("锤子");
        tb2.work();
        // 此时，将标签tb2上记录的锤子工具箱位置，记录到标签tb上
        // 即，tb标签也记录着锤子工具箱的位置
        tb = tb2;
        // 此时，还有任何关于钳子工具箱位置的记录么？
        // 钳子工具箱会发生什么？
        // 钳子工具箱会被系统认定没有人使用而销毁

        // 将tb1标签上的位置记录信息抹去
        // 即，将其上当前锤子工具箱位置删除
        tb = null;
        // 此时，锤子工具箱会发生什么？
        // 哈哈，此时标签tb2上还记录着锤子工具箱的位置,因此，不会被销毁。
        // 但如果方法结束后，再没有关于锤子工具箱位置的记录，则会被系统销毁
    }
}
