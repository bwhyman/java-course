package p6.optional;

import java.nio.file.Files;
import java.util.Optional;

public class OptionalTest {
    /**
     * 基于指定课程，打印课程名称
     * @param course
     */
    private static void print(Course course) {
        Optional.ofNullable(course)
                .ifPresent(c -> System.out.println(c.getName()));
    }

    /**
     * 基于给定课程，如果课程不是选修课，返回课程的名称
     * 任何不符合条件，返回 课程不存在
     * @param course
     * @return
     */
    private static String filter(Course course) {
        return Optional.ofNullable(course)
                .filter(c -> !c.isElective())
                .map(Course::getName)
                .orElse("课程不存在");
    }

    /**
     * 基于给定课程，如果课程是选修课，返回课程的授课教师的姓名
     * 任何不符合条件，返回 教师未知
     * @param course
     * @return
     */
    private static String map(Course course) {
        return Optional.ofNullable(course)
                .filter(Course::isElective)
                .map(Course::getTeacher)
                .map(Teacher::getName)
                .orElse("教师未知");
    }
}
