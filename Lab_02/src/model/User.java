package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {

    String name;
    String surName;
    String login;
    String psw;
    int year;
    ArrayList<Course> myEnrolledCourses;
    boolean isModerator = false;
    ArrayList<Course> myAdministratedCourses;
    String bankAccount;

    public User(String name,
                String surName,
                String login,
                String psw,
                int year,
                ArrayList<Course> myEnrolledCourses,
                boolean isModerator,
                ArrayList<Course> myAdministratedCourses,
                String bankAccount) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.psw = psw;
        this.year = year;
        this.myEnrolledCourses = myEnrolledCourses;
        this.isModerator = isModerator;
        this.myAdministratedCourses = myAdministratedCourses;
        this.bankAccount = bankAccount;
    }

    public User(String name, String surName, String login) {
        this.name = name;
        this.surName = surName;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Course> getMyEnrolledCourses() {
        return myEnrolledCourses;
    }

    public void setMyEnrolledCourses(ArrayList<Course> myEnrolledCourses) {
        this.myEnrolledCourses = myEnrolledCourses;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }

    public ArrayList<Course> getMyAdministratedCourses() {
        return myAdministratedCourses;
    }

    public void setMyAdministratedCourses(ArrayList<Course> myAdministratedCourses) {
        this.myAdministratedCourses = myAdministratedCourses;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Musu didenybe " + name + " " + surName + " {" + login + "}" + " {" + psw + "}" + " {" + year + "}";
    }

    public static void manageUsers(Scanner scanner, CourseIS courseIS, User user) {
        String userCmd = "";
        while (!userCmd.equals("back")) {
            System.out.println("main/user/  \n" +
                    "\t add - add user \n" +
                    "\t upd - update user \n" +
                    "\t del - delete user \n" +
                    "\t print - print users \n" +
                    "\t back - return to main menu \n");

            userCmd = scanner.next();
            switch (userCmd) {
                case "add":
                    addUser(scanner, courseIS);
                    break;
                case "upd":
                    updateUser(scanner, courseIS);
                    break;
                case "del":
                    deleteUser(scanner, courseIS);
                    break;
                case "print":
                    for (User user1 : courseIS.getAllUsers()) {
                        System.out.println(user1.toString());
                    }
                    break;
                case "back":
                    System.out.println("going up \n");
                    break;
                default:
                    System.out.println("wrong command \n");
            }
        }
    }

    public static User getUserByName(ArrayList<User> userName, String vartotojoVardas) {
        return userName.stream().filter(user -> user.getName().equals(vartotojoVardas)).findFirst().orElseGet(null);
    }

    public static void addUser(Scanner scanner, CourseIS courseIS) {
        System.out.println("Enter user info: {name};{surname};{login};{psw};{year}");
        String[] values = scanner.next().split(";");

        System.out.println("\n Pridetas useris: " + values[0] + "    " + values[1] + "    " + values[2] +
                "    " + values[3] + "    " + values[4] + " \n");
        courseIS.getAllUsers().add(new User(values[0],
                values[1],
                values[2],
                values[3],
                Integer.parseInt(values[4]),
                new ArrayList<Course>(),
                true,
                new ArrayList<Course>(), "0"));
    }

    public static void updateUser(Scanner scanner, CourseIS courseIS) {
        System.out.println("Iveskite userio varda");
        String updatinamasUseris = scanner.next();

        User user = getUserByName(courseIS.getAllUsers(), updatinamasUseris);

        if (user != null) {
            System.out.println("Update {name};{surname};{login};{psw};{year} ;-; - jei nekeiciam");
            String[] values = scanner.next().split(";");

            if (!values[0].equals("-")) {
                user.setName(values[0]);
            }
            if (!values[1].equals("-")) {
                user.setSurName(values[1]);
            }
            if (!values[2].equals("-")) {
                user.setLogin(values[2]);
            }
            if (!values[3].equals("-")) {
                user.setPsw(values[3]);
            }
            if (!values[4].equals("-")) {
                user.setYear(Integer.parseInt(values[4]));
            }
        }
    }

    private static void deleteUser(Scanner scanner, CourseIS courseIS) {
        System.out.println("Iveskite norimo istrinti userio varda");
        String trinamasUseris = scanner.next();

        User user = getUserByName(courseIS.getAllUsers(), trinamasUseris);

        if (user != null) {
            courseIS.getAllUsers().remove(user);
            System.out.println("useris " + user.getName() + " istrintas \n");
        } else {
            System.out.println("Useris Neissitrina \n");
        }
    }

}
