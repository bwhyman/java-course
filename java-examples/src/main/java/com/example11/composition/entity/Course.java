package com.example11.composition.entity;

public class Course {
        private String name;
        private Teacher teacher;
        private Student[] students;

    public Course(String name) {
        this.name = name;
    }
    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
