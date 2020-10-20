import model.Course;
import model.CourseIS;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        CourseIS courseIS = new CourseIS
                (new ArrayList<Course>(), new ArrayList<User>(), "Newer Moodle", LocalDate.now());

        Scanner scanner = new Scanner(System.in);
        String cmd = "";

        while (!cmd.equals("quit")) {
            System.out.println("Pasirinkite - choose an area: \n" +
                    "\t course - manage courses\n" +
                    "\t user manage users\n" +
                    "\t quit - exit system");
            cmd = scanner.next();

            switch (cmd) {
                case "course":
                    manageCoureses(scanner, courseIS);
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


//       ---------------------------------------
    }

    private static void manageUsers(Scanner scanner, CourseIS courseIS) {
    }

    private static void manageCoureses(Scanner scanner, CourseIS courseIS) {
        String courseCmd = "";
        while (!courseCmd.equals("quit")) {
            System.out.println("Pasirinkite - choose an action: \n" +
                    "\t add - add a course to system \n" +
                    "\t upd - update acourse \n" +
                    "\t del - remove the course \n" +
                    "\t enroll - enroll the course \n" +
                    "\t folder - manage the folders \n" +
                    "\t file - manage files \n");

            courseCmd = scanner.next();

            switch (courseCmd) {
                case "add":
                    //paprasyti vartotojo ivesti kursa
                    courseIS.getAllCourses().add(new Course());
                    break;
                case "upd":
                    //surasti pagal pavadinima kursa ir paklausti kokius duomenis atnaujinti

                    break;
                case "del":
                    //surasti pagal pavadinima kursa ir ji pasalinti
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

    private static void manageCourseFiles(Scanner scanner, CourseIS courseIS) {
    }

    private static void manageCourseFolders(Scanner scanner, CourseIS courseIS) {
    }

//       ---------------------------------------
}























/*
        Course testCourse = new Course();
        testCourse.setCoursenamwe("Test course");           //setteris
        System.out.println(testCourse.getCoursenamwe());    //getteris*/