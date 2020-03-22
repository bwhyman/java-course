package com.example11.composition;

public class CompositionTest {
    public static void main(String[] args) {
        testCreateCourse();
    }

    private static void testCreateCourse() {
        Course course = new Course("Java");
        Teacher teacher = new Teacher(1001, "BO");
        course.setTeacher(teacher);
        System.out.println(course.getName());
        System.out.println(course.getTeacher().getName());

        Student s1 = new Student(2018001, "Li", true);
        Student s2 = new Student(2018005, "Liu", true);
        Student s3 = new Student(2018012, "Zhao", false);
        Student[] ss = {s1, s2, s3};
        course.setStudents(ss);

        for (Student s : course.getStudents()) {
            System.out.println(s.isLazy());
        }

    }
}
