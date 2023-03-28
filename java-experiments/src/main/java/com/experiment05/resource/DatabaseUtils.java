package com.experiment05.resource;


import com.experiment05.entity.College;
import com.experiment05.entity.Student;
import com.experiment05.entity.Teacher;

import java.util.List;

public class DatabaseUtils {
    private static final List<Student> STUDENTS = create();

    private static List<Student> create() {
        College c1 = new College("信息学院");
        College c2 = new College("经济管理学院");

        Teacher t1 = new Teacher(1001, "吕惠玲");
        t1.setCollege(c1);
        Teacher t2 = new Teacher(1002, "曾志优");
        t2.setCollege(c2);

        Student s1 = new Student(201001,"赵阳阳", 2010);
        s1.setTeacher(t1);
        Student s2 = new Student(201002,"邵鹏", 2010);
        s2.setTeacher(t1);
        Student s3 = new Student(201103,"高学斌", 2011);
        s3.setTeacher(t2);
        Student s4 = new Student(201104,"张扬", 2011);
        s4.setTeacher(t2);

        return List.of(s1,s2, s3, s4);
    }

    public static List<Student> listStudents() {
        return STUDENTS;
    }



}
