package Lab6;

import java.util.ArrayList;

public class Course {
    private int courseId;
    private int creditPoints;
    private int year;
    private String fullName;
    private ArrayList<Student> students;

    public Course(int courseId, int creditPoints, int year, String fullName, ArrayList<Student> students) {
        this.courseId = courseId;
        this.creditPoints = creditPoints;
        this.year = year;
        this.fullName = fullName;
        this.students = students;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", creditPoints=" + creditPoints +
                ", year=" + year +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
