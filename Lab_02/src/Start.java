import model.Course;
import model.CourseIS;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static model.Course.manageCourses;
import static model.User.manageUsers;

public class Start {
    public static void main(String[] args) {
        CourseIS courseIS = new CourseIS(new ArrayList<Course>(), new ArrayList<User>(), "Newer Moodle", LocalDate.now());
        System.out.println("hallo");

        User loggedUser = new User("Arunas", "Mincevicius", "ArasLT");
        System.out.println(loggedUser.toString());

        User anotherUser = new User("Vardas", "Pavarde", "loginas");
        System.out.println(anotherUser.toString());

//        Course currentCourse = new Course("Esamasis kursas");
//        System.out.println(currentCourse.toString());

        Scanner scanner = new Scanner(System.in);
        String cmd = "";

        while (!cmd.equals("quit")){
            System.out.println("main/ \n" +
                    "\t course - manage courses\n" +
                    "\t user - manage users\n" +
                    "\t quit - exit system");
            cmd = scanner.next();
            switch (cmd) {
                case "course":
                    manageCourses(scanner, courseIS, loggedUser);
                    break;
                case "user":
                    manageUsers(scanner, courseIS, anotherUser);
                    break;
                case "quit":
                    System.out.println("bye bye \n");
                    break;
                default:
                    System.out.println("wrong command \n");
            }
        }

    }//--2
}//--1
