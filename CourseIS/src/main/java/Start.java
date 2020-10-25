import model.*;
import utils.CourseManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        CourseIS courseIS = new CourseIS
                (new ArrayList<Course>(), new ArrayList<User>(), "Newer Moodle", LocalDate.now());

        User loggedUser = new User("Admin", "Ädminas", "admin", "root", 1965,
                new ArrayList<Course>(), true, new ArrayList<Course>(), "");
        Scanner scanner = new Scanner(System.in);
        String cmd = "";

        while (!cmd.equals("quit")) {
            System.out.println("Pasirinkite - choose an area: \n" +
                    "\t course - manage courses\n" +
                    "\t user - manage users\n" +
                    "\t quit - exit system");
            cmd = scanner.next();

            switch (cmd) {
                case "course":
                    CourseManagement.manageCoureses(scanner, courseIS, loggedUser);
                    break;
                case "user":
                    manageUsers(scanner, courseIS);
                    break;
                case "quit":
                    System.out.println("bye bye \n");
                    break;
                default:
                    System.out.println("wrong command \n");
            }
        }


    }           //      2 ---------------------------------------

    private static void manageUsers(Scanner scanner, CourseIS courseIS) {
    }

    private static void manageCourseFiles(Scanner scanner, CourseIS courseIS) {
    }

    private static void manageCourseFolders(Scanner scanner, CourseIS courseIS) {
    }


}           //      1 ---------------------------------------























/*
        Course testCourse = new Course();
        testCourse.setCoursenamwe("Test course");           //setteris
        System.out.println(testCourse.getCoursenamwe());    //getteris*/