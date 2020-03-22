package com.experiment04.service;

import com.experiment04.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    /**
     * 向集合添加一个学生，返回当前全部学生
     * @param student
     * @return
     */
    List<Student> addStudent(Student student);

    /**
     * 返回指定届的全部学生
     * @param year
     * @return
     */
    List<Student> listStudentsByYear(int year);

    /**
     * 返回指定届，指定性别的全部学生的姓名
     * @param year
     * @param sex
     * @return
     */
    List<String> listStudentsNames(int year, Student.Sex sex);

    /**
     * 将所有学生，以性别分组
     * @return
     */
    Map<Student.Sex, List<Student>> mapStudentsBySex();

    /**
     * 删除指定学号的学生，返回是否成功删除
     * @param id
     * @return
     */
    boolean removeStudent(int id);
}

