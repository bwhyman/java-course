package com.experiment04.resource;

import com.experiment04.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final List<Student> STUDENTS = create();
    private static List<Student> create() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(201001, Student.Sex.FEMALE, "赵阳阳", 2010));
        students.add(new Student(201002, Student.Sex.MALE, "邵鹏", 2010));
        students.add(new Student(201103, Student.Sex.MALE, "高学斌", 2011));
        students.add(new Student(201104, Student.Sex.MALE, "张扬", 2011));
        students.add(new Student(201205, Student.Sex.FEMALE, "吕惠玲", 2012));
        students.add(new Student(201206, Student.Sex.MALE, "曾志优", 2012));
        return students;
    }

    public static List<Student> getStudents() {
        return STUDENTS;
    }
}
