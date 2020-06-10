package p6.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    private static final List<Student> STUDENTS = create();
    private static final String CLAZZ1 = "软件1班";
    private static final String CLAZZ2 = "软件2班";
    private static List<Student> create() {
        Student s1 = new Student(2018008, "张扬", CLAZZ2, 66);
        Student s2 = new Student(2018005, "刘飞", CLAZZ1, 52);
        Student s3 = new Student(2018007, "李明", CLAZZ2, 84);
        Student s4 = new Student(2018006, "赵勇", CLAZZ2, 56);
        Student s5 = new Student(2018002, "王磊", CLAZZ1, 81);
        Student s6 = new Student(2018010, "牛娜", CLAZZ1, 78);
        List<Student> students = new ArrayList<>();
        students.add(s1);students.add(s2);students.add(s3);
        students.add(s4);students.add(s5);students.add(s6);
        return students;
    }

    public static void main(String[] args) {
        // listStudentsSorted().forEach(student -> System.out.println(student.getScore()));
        
        listStudentsSorted(100, CLAZZ2).forEach(student -> System.out.println(student.getName()));
        // listStudentsSorted2(60, CLAZZ1).forEach(System.out::println);
        /*listStudentsSorted3(100, CLAZZ1).forEach((k, v) -> {
            System.out.println(k + "/" + v);
        });*/
    }

    /**
     * 获取成绩小于等于指定分数，的全部学生
     * @param score
     * @return
     */
    private static List<Student> listStudents(int score) {
        return STUDENTS.stream()
                .filter(s -> s.getScore() <= score)
                .collect(Collectors.toList());
    }

    /**
     * 获取指定班级，成绩小于等于指定分数，的全部学生
     * @param score
     * @param clazz
     * @return
     */
    private static List<Student> listStudents(int score, String clazz) {
        return STUDENTS.stream()
                .filter(s -> clazz.equals(s.getClazz()))
                .filter(s -> s.getScore() <= score)
                .collect(Collectors.toList());
    }

    /**
     * 获取指定班级，成绩小于等于指定分数，的全部学生的姓名。注意返回类型
     * @param calzz
     * @return
     */
    private static List<String> listStudents(String calzz) {
        return STUDENTS.stream()
                .filter(s -> calzz.equals(s.getClazz()))
                .filter(s -> s.getScore() <= 60)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    /**
     * 按成绩由低到高排序，返回全部学生
     * @return
     */
    private static List<Student> listStudentsSorted() {
        return STUDENTS.stream()
                .sorted(Comparator.comparing(Student::getScore))
                .collect(Collectors.toList());
    }

    /**
     * 获取指定班级，成绩小于等于指定分数，成绩由高到低排序，的全部学生
     * @param score
     * @param clazz
     * @return
     */
    private static List<Student> listStudentsSorted(int score, String clazz) {
        return STUDENTS.stream()
                .filter(s -> clazz.equals(s.getClazz()))
                .filter(s -> s.getScore() <= score)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .collect(Collectors.toList());
    }

    /**
     * 获取指定班级，成绩小于等于指定分数，成绩由高到低排序，的全部学生的学号。注意返回类型
     * @param score
     * @param clazz
     * @return
     */
    private static List<Integer> listStudentsSorted2(int score, String clazz) {
        return STUDENTS.stream()
                .filter(s -> clazz.equals(s.getClazz()))
                .filter(s -> s.getScore() <= score)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getNumber)
                .collect(Collectors.toList());
    }

    /**
     * 获取指定班级，成绩小于等于指定分数，的全部学生，成绩由高到低排序
     * 以学生学号为键，学生分数为值，Map分组，返回
     * @param score
     * @param clazz
     * @return
     */
    private static Map<Integer, Integer> listStudentsSorted3(int score, String clazz) {
        return STUDENTS.stream()
                .filter(s -> clazz.equals(s.getClazz()))
                .filter(s -> s.getScore() <= score)
                .sorted(Comparator.comparing(Student::getScore))
                .collect(Collectors.toMap(Student::getNumber, Student::getScore));
    }

}
