package utils;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagement {

    public static void manageCoureses(Scanner scanner, CourseIS courseIS, User user) {
        String courseCmd = "";
        while (!courseCmd.equals("quit")) {
            System.out.println("Pasirinkite - choose an action: \n" +
                    "\t add - add a course to system \n" +
                    "\t upd - update acourse \n" +
                    "\t del - remove the course \n" +
                    "\t print - print all courses \n" +
                    "\t enroll - enroll the course \n" +
                    "\t folder - manage the folders \n" +
                    "\t file - manage files \n");

            courseCmd = scanner.next();

            switch (courseCmd) {
                case "add":
                    addCourse(scanner, courseIS, user);
                    //paprasom vartotojo ivesti kursa
                    break;
                case "upd":
                    //surasti pagal pavadinima kursa ir paklausti kokius duomenis atnaujinti

                    break;
                case "del":
                    //surasti pagal pavadinima kursa ir ji pasalinti
                    break;
                case "print":
                    courseIS.getAllCourses().forEach(course -> System.out.println(course.toString()));
                    break;
                case "enroll":
                    //surasti pagal pavadinima kursa ir ji prideti i pasirinku sarasa
                    break;
                case "folder":
                    //persokti i folder menu pagal nurodyta kursa
                    manageCourseFolders(scanner, courseIS);
                    break;
                case "file":
                    //persokti i file menu pagal nurodyta kursa, Kursa nurodome viduje uzklausiant.
                    manageCourseFiles(scanner, courseIS);
                    break;
                case "quit":
                    System.out.println("return to main menu \n");
                    break;
                default:
                    System.out.println("wrong command \n");
            }
        }
    }

    private static void addCourse(Scanner scanner, CourseIS courseIS, User user) {
        System.out.println("Enter course info{title}; {start date}; {end date]");
        String[] values = scanner.next().split(";");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);

        System.out.println(values[0] + "   " + values[1] + "   " + values[2]);
        courseIS.getAllCourses().add(new Course(values[0],
                0,
                new ArrayList<CourseFile>(),
                new ArrayList<Folder>(),
                users,
                LocalDate.now(), //LocalDate.of(values[1]),
                LocalDate.now(), //LocalDate.of(values[2]),
                LocalDate.now()));
    }

    private static void manageCourseFolders(Scanner scanner, CourseIS courseIS) {
    }

    private static void manageCourseFiles(Scanner scanner, CourseIS courseIS) {
    }

}
