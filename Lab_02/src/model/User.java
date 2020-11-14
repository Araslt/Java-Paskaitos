package model;

import java.io.Serializable;
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

    public User() {
    }

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
                    "\t update - update user \n" +
                    "\t delete - delete user \n" +
                    "\t print - print users \n" +
                    "\t back - return to main menu \n");

            userCmd = scanner.next();
            switch (userCmd) {
                case "add":
                    addUser(scanner, courseIS, user);
                    break;
                case "update":
                    //updateUser()
                    break;
                case "delete":
                    //deleteUser()
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
    public static void addUser(Scanner scanner, CourseIS courseIS, User user) {
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


}
