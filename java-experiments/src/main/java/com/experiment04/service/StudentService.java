package com.experiment04.service;

import com.experiment04.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    /**
     * 向集合添加一名学生，返回当前全部学生
     * @param student
     * @return
     */
    List<Student> addStudent(Student student);

    /**
     * 列出指定年级的全部学生
     * @param year
     * @return
     */
    List<Student> listStudentsByYear(int year);

    /**
     * 列出指定年级，指定性别的全部学生的姓名
     * @param year
     * @param sex
     * @return
     */
    List<String> listStudentsNames(int year, Student.Sex sex);

    /**
     * 列出指定年级的全部学生，按学生ID逆序排列
     * @param year
     * @return
     */
    List<Student> listStudentsByYearSortedById(int year);

    /**
     * 将所有学生，以性别分组
     * @return
     */
    Map<Student.Sex, List<Student>> listStudentsMapBySex();

    /**
     * 列出指定年级学生，按学号分组
     * @return
     */
    Map<Integer, Student> listStudentsByYearMapById(int year);

    /**
     * 移除指定学号的学生，返回是否成功移除
     * @param id
     * @return
     */
    boolean removeStudent(int id);
}

