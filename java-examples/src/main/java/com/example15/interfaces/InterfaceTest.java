package com.example15.interfaces;

public class InterfaceTest {

    public static void main(String[] args) {
        getAble();
        System.out.println("-------interface imp --------");
        getUniversityClub();
    }

    private static void getAble() {
        Learnable under = new Undergraduate("BO");
        under.test("Java");
        Learnable post = new Postgraduate("ZHANG");
        post.test("Java");

    }

    private static void getUniversityClub() {
        // Undergraduate实现了Learnable接口，表示其具有相应能力
        // 创建一个具有Learnable能力的本科生
        Learnable under = new Undergraduate("BO");
        UniversityClub club = new UniversityClub("读书会");
        club.setLearnable(under);
        club.getLearnable().read("C++");
        Learnable post = new Postgraduate("SUN");
        club.setLearnable(post);
        club.getLearnable().read("C++");
    }

}
