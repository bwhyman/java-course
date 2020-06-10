package p6.optional;

public class Course {
    private String name;
    private boolean elective;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean isElective() {
        return elective;
    }

    public void setElective(boolean elective) {
        this.elective = elective;
    }
}
