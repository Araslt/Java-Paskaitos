package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class CourseIS implements Serializable {
    private ArrayList<Course> allCourses;
    private ArrayList<User> allUsers;
    private String sysName;
    private LocalDate dateCreated;

    public CourseIS() {
    }

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

    @Override
    public String toString() {
        return "CourseIS{" +
                "Visi kursai - Courses in the system" + allCourses +
                ", Visi vartotojai - All users in the system" + allUsers +
                ", Vardas - name='" + sysName + '\'' +
                ", sukurimo data - data created=" + dateCreated +
                '}';
    }
}
