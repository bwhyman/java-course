package p6.stream;

public class Student {
    private int number;
    private String name;
    private String clazz;
    private int score;

    public Student(int number, String name, String clazz, int score) {
        this.number = number;
        this.name = name;
        this.clazz = clazz;
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
