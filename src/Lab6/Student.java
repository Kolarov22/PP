package Lab6;

import java.util.ArrayList;

public class Student {
    private int studentId;
    private String name;
    private String group;
    private ArrayList<Course> courses;

    public Student(int studentId, String name, String group, ArrayList<Course> courses) {
        this.studentId = studentId;
        this.name = name;
        this.group = group;
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
