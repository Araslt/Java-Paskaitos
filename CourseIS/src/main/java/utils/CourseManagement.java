package utils;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

import static utils.FileIO.ReadCourseFromFile;
import static utils.FileIO.WriteCourseToFile;

public class CourseManagement {

    public static void manageCoureses(Scanner scanner, CourseIS courseIS, User user) {
        String courseCmd = "";
        while (!courseCmd.equals("back")) {
            System.out.println("Pasirinkite - choose an action: \n" +
                    "\t add - add a course to system \n" +
                    "\t upd - update a course \n" +
                    "\t del - remove the course \n" +
                    "\t print - print all courses \n" +
                    "\t printf - print all courses from file \n" +
                    "\t enroll - enroll the course \n" +
                    "\t folder - manage the folders \n" +
                    "\t file - manage files \n" +
                    "\t back - back to menu \n");

            courseCmd = scanner.next();
            switch (courseCmd) {
                case "add":                    //paprasom vartotojo ivesti kursa
                    addCourse(scanner, courseIS, user);
                    WriteCourseToFile(courseIS);
                    break;
                case "upd":
                    //updateCourse();
                    //surasti pagal pavadinima kursa ir paklausti kokius duomenis atnaujinti
                    break;
                case "del":
                    deleteCourse(scanner, courseIS, user);
                    WriteCourseToFile(courseIS);
                    //surasti pagal pavadinima kursa ir ji pasalinti
                    break;
                case "print":
                    courseIS.getAllCourses().forEach(course -> System.out.println(course.toString()));
                    break;
                case "printf":
                    ReadCourseFromFile(courseIS);
                    break;
                case "enroll":
                    //surasti pagal pavadinima kursa ir ji prideti i pasirinktu sarasa
                    break;
                case "folder":
                    //persokti i folder menu pagal nurodyta kursa
                    manageCourseFolders(scanner, courseIS);
                    break;
                case "file":
                    //persokti i file menu pagal nurodyta kursa, Kursa nurodome viduje uzklausiant.
                    manageCourseFiles(scanner, courseIS, user);
                    break;
                case "back":
                    System.out.println("return to main menu \n");
                    break;
                default:
                    System.out.println("wrong command \n");
            }
        }
    }

    private static void addCourse(Scanner scanner, CourseIS courseIS, User user) {
        System.out.println("Enter course info: {title};{start date};{end date]");
        String[] values = scanner.next().split(";");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);

        System.out.println("Pridetas kursas: " + values[0] + "   " + values[1] + "   " + values[2] + "\n");
        courseIS.getAllCourses().add(new Course(values[0],
                0,
                new ArrayList<CourseFile>(),
                new ArrayList<Folder>(),
                users,
                LocalDate.now(), //LocalDate.of(values[1]),
                LocalDate.now(), //LocalDate.of(values[2]),
                LocalDate.now()));
    }

    private static void updateCourse(Scanner scanner, CourseIS courseIS, User user) {
        System.out.println("Iveskite updeitinamo kurso pavadinima");
        String kursoPavadinimas = scanner.next();

        Course course = getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);
        if (course != null) {
            course.setCourseName("nieko sqau kursas");
        }

    }

    private static void deleteCourse(Scanner scanner, CourseIS courseIS, User user) {
        System.out.println("Iveskite norimo istrinti kurso pavadinima");
        String kursoPavadinimas = scanner.next();

        Course course = getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);
        if (course != null) {
            courseIS.getAllCourses().remove(course);}
            else
            {
                System.out.println("Nothing to remove\n");
            }
        }



    public static Course getCourseByName(ArrayList<Course> allCourses, String name) {
        return allCourses.stream().filter(course -> course.getCourseName().equals(name)).findFirst().orElseGet(null);
    }

    private static boolean courseExist(ArrayList<Course> courses, String name) {
        return courses.stream().anyMatch(course -> course.getCourseName().equals(name));
    }

    private static void manageCourseFolders(Scanner scanner, CourseIS courseIS) {
    }

    private static void manageCourseFiles(Scanner scanner, CourseIS courseIS, User user) {
        System.out.println("Koks kursas?");
    }

}























