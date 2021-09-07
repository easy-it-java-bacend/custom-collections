package model;

public class Student implements Comparable<Student> {

    private String name;
    private Double gpa;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }


    @Override
    public int compareTo(Student other) {
        if (this.gpa > other.gpa) {
            return 1;
        }
        if (this.gpa < other.gpa) {
            return -1;
        }
        return 0;
    }
}
