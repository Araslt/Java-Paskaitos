package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class CourseIS implements Serializable {
    private ArrayList<Course> allCourses = new ArrayList<Course>();
    private ArrayList<User> allUsers = new ArrayList<User>();
    private String sysName;
    private LocalDate dateCreated;

    public CourseIS(ArrayList<Course> allCourses, ArrayList<User> allUsers, String sysName, LocalDate dateCreated) {
        this.allCourses = allCourses;
        this.allUsers = allUsers;
        this.sysName = sysName;
        this.dateCreated = dateCreated;
    }

    public ArrayList<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(ArrayList<Course> allCourses) {
        this.allCourses = allCourses;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toString() {
        return "CourseIS{" +
                "Users in the system=" + allUsers +
                ", Courses in the system=" + allCourses +
                ", Name='" + sysName + '\'' +
                ", Created=" + dateCreated +
                '}';
    }
}
