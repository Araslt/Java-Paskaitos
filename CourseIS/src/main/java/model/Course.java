package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Course implements Serializable {

    private String coursenamwe;         //private - priklauso tik sitai klasei, is kitu - nematys
    private int numberOfEnrolledUsers;
    private ArrayList<CourseFile> courseFiles;
    private ArrayList<Folder> courseFolders;
    private ArrayList<User> courseModerators;
    private LocalDate courseStart;
    private LocalDate courseEnd;
    private LocalDate courseCreated;

    /*
        defaultinis konstruktorius - alt insert - select none
    */

    public Course() {
    }

    /*
        pirminis reiksiu priskyrimas vykdomas naudojant konstruktoriu
        t.y. konstruktorius kurimo metu priskirs uzprogramuotas reiksmes
    */
    public Course(String coursenamwe,
                  int numberOfEnrolledUsers,
                  ArrayList<CourseFile> courseFiles,
                  ArrayList<Folder> courseFolders,
                  ArrayList<User> courseModerators,
                  LocalDate courseStart,
                  LocalDate courseEnd,
                  LocalDate courseCreated) {
        this.coursenamwe = coursenamwe;
        this.numberOfEnrolledUsers = numberOfEnrolledUsers;
        this.courseFiles = courseFiles;
        this.courseFolders = courseFolders;
        this.courseModerators = courseModerators;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.courseCreated = courseCreated;
    }

    public int getNumberOfEnrolledUsers() {
        return numberOfEnrolledUsers;
    }

    public void setNumberOfEnrolledUsers(int numberOfEnrolledUsers) {
        this.numberOfEnrolledUsers = numberOfEnrolledUsers;
    }

    public ArrayList<CourseFile> getCourseFiles() {
        return courseFiles;
    }

    public void setCourseFiles(ArrayList<CourseFile> courseFiles) {
        this.courseFiles = courseFiles;
    }

    public ArrayList<Folder> getCourseFolders() {
        return courseFolders;
    }

    public void setCourseFolders(ArrayList<Folder> courseFolders) {
        this.courseFolders = courseFolders;
    }

    public ArrayList<User> getCourseModerators() {
        return courseModerators;
    }

    public void setCourseModerators(ArrayList<User> courseModerators) {
        this.courseModerators = courseModerators;
    }

    public LocalDate getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(LocalDate courseStart) {
        this.courseStart = courseStart;
    }

    public LocalDate getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(LocalDate courseEnd) {
        this.courseEnd = courseEnd;
    }

    public LocalDate getCourseCreated() {
        return courseCreated;
    }

    public void setCourseCreated(LocalDate courseCreated) {
        this.courseCreated = courseCreated;
    }

    public String getCoursenamwe() {
        return coursenamwe;
    }

    public void setCoursenamwe(String coursenamwe) {
        this.coursenamwe = coursenamwe;
    }
}
