package com.example33.annotation;

@Preamble(
        author = "BO",
        date = "2046-06-01",
        lastModified = "2046-07-28",
        lastModifiedBy = "SUN",
        reviewers = {"Alice", "Bob", "Cindy"}
)

public class Test {
    public static String NAME = "BO";
    public static void main(String[] args) {
        getDeprecated();
        getAnnotations();
    }

    // 通过反射，动态获取注解以及注解元素中的值
    @Authority(Authority.AuthorityType.SUPERADMIN)
    private static void getAnnotations() {
        Preamble[] preambles = Test.class.getAnnotationsByType(Preamble.class);
        for (Preamble p : preambles) {
            System.out.println(p.author());
            System.out.println(p.date());
            System.out.println(p.currentRevision());
        }
    }
    @Deprecated
    private static void getDeprecated() {
    }

}
