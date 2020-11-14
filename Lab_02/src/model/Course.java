package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import static model.CourseFile.manageCourseFile;
import static utils.FileIO.*;

public class Course implements Serializable {
    private String courseName;
    private int numberOfEnrolledUsers;
    private ArrayList<CourseFile> courseFiles;
    private ArrayList<User> enrolledUsers;
    private ArrayList<Folder> courseFolders;
    private ArrayList<User> courseModerators;
    private LocalDate courseStart;
    private LocalDate courseEnd;
    private LocalDate courseCreated;

/*    public Course(String courseName,
                  int i,
                  ArrayList<CourseFile> courseFiles,
                  ArrayList<Folder> folders,
                  ArrayList<User> users,
                  LocalDate now,
                  LocalDate localDate,
                  LocalDate date) {
        this.courseName = courseName;
    }*/

    public Course(String courseName,
                  int numberOfEnrolledUsers,
                  ArrayList<CourseFile> courseFiles,
                  ArrayList<User> enrolledUsers,
                  ArrayList<Folder> courseFolders,
                  ArrayList<User> courseModerators,
                  LocalDate courseStart,
                  LocalDate courseEnd,
                  LocalDate courseCreated) {
        this.courseName = courseName;
        this.numberOfEnrolledUsers = numberOfEnrolledUsers;
        this.courseFiles = courseFiles;
        this.enrolledUsers = enrolledUsers;
        this.courseFolders = courseFolders;
        this.courseModerators = courseModerators;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.courseCreated = courseCreated;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public ArrayList<User> getEnrolledUsers() {
        return enrolledUsers;
    }

    public void setEnrolledUsers(ArrayList<User> enrolledUsers) {
        this.enrolledUsers = enrolledUsers;
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

    @Override
    public String toString() {
        return "Course{"
                + "courseName="
                + courseName
                + '\''
                + ", numberOfEnrolledUsers="
                + numberOfEnrolledUsers
                + ", courseFiles="
                + courseFiles
                + ", enrolledUsers="
                + enrolledUsers
                + ", courseFolders="
                + courseFolders
                + ", courseModerators="
                + courseModerators
                + ", courseStart="
                + courseStart
                + ", courseEnd="
                + courseEnd
                + ", courseCreated="
                + courseCreated
                + '}';
    }

    public static void manageCourses(Scanner scanner, CourseIS courseIS, User user) {
        String courseCmd = "";
        while (!courseCmd.equals("back")) {
            System.out.println("main/course/ \n" +
                    "\t add - add a course to system \n" +
                    "\t upd - update a course \n" +
                    "\t del - remove the course \n" +
                    "\t enroll - enroll the course \n" +
                    "\t print - print all courses \n" +
                    "\t printf - print all courses from DB file \n" +
                    "\t folder - manage the folders \n" +
                    "\t file - manage course files \n" +
                    "\t back - return to main menu \n");

            courseCmd = scanner.next();
            switch (courseCmd) {
                case "add":
                    addCourse(scanner, courseIS, user);
                    break;
                case "upd":
                    updateCourse(scanner, courseIS);
                    break;
                case "del":
                    deleteCourse(scanner, courseIS);
                    break;
                case "enroll":
                    //surasti pagal pavadinima kursa ir ji prideti i pasirinktu sarasa
                    break;
                case "print":
                    for (Course course : courseIS.getAllCourses()) {
                        System.out.println(course.toString());
                    }
                    //courseIS.getAllCourses().forEach(course -> System.out.println(course.toString()));
                    break;
                case "printf":
                    ReadCourseFromDBFile(courseIS);
                    break;
                case "folder":
                    //persokti i folder menu pagal nurodyta kursa
                    //manageCourseFolders();
                    break;
                case "file":
                    manageCourseFile(scanner, courseIS, user);
                    break;
                case "back":
                    System.out.println("going up \n");
                    break;
                default:
                    System.out.println("wrong command \n");
            }
        }
    }

    public static Course getCourseByName(ArrayList<Course> allCourses, String kursoPavadinimas) {
        return allCourses.stream().filter(course -> course.getCourseName().equals(kursoPavadinimas)).findFirst().orElseGet(null);
    }

    private static boolean courseExists(ArrayList<Course> courses, String kursoPavadinimas) {
        return courses.stream().anyMatch(course -> course.getCourseName().equals(kursoPavadinimas));
    }

    private static void addCourse(Scanner scanner, CourseIS courseIS, User user) {
        System.out.println("Enter course info: {title};{start date};{end date]");
        String[] values = scanner.next().split(";");

        ArrayList<User> users = new ArrayList<User>();
        users.add(user);

        System.out.println("\n Pridetas kursas: " + values[0] + "   Pradzia: " + values[1] + "   Pabaiga: " + values[2] + " \n");
        courseIS.getAllCourses().add(new Course(values[0],
                0,
                new ArrayList<CourseFile>(),
                new ArrayList<User>(),
                new ArrayList<Folder>(),
                users,
                LocalDate.parse(values[1]),
                LocalDate.parse(values[2]),
                LocalDate.now()));
    }

    public static void updateCourse(Scanner scanner, CourseIS courseIS) {
        System.out.println("Iveskite kurso pavadinima");
        String kursoPavadinimas = scanner.next();

        Course course = getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);

        if (course != null) {
            System.out.println("Update {title};{start date};{end date} ;-; - jei nekeiciam");
            String[] values = scanner.next().split(";");

            if (!values[0].equals("-")) {
                course.setCourseName(values[0]);
            }
            if (!values[1].equals("-")) {
                course.setCourseStart(LocalDate.parse(values[1]));
            }
            if (!values[2].equals("-")) {
                course.setCourseEnd(LocalDate.parse(values[2]));
            }
        }
    }

    private static void deleteCourse(Scanner scanner, CourseIS courseIS) {
        System.out.println("Iveskite norimo istrinti kurso pavadinima");
        String kursoPavadinimas = scanner.next();

        Course course = getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);

        if (course != null) {
            courseIS.getAllCourses().remove(course);
            System.out.println("kursas " + course.getCourseName() + " istrintas \n");
        } else {
            System.out.println("Neissitrina \n");
        }
    }


}//--1
