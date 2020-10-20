package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    String name;
    String surName;
    String login;
    String psw;
    int year;
    ArrayList<Course> myEnrolledCourses;
    boolean isdModerator = false;
    ArrayList<Course> myAdministratedCourses;
    String bankAccount;

    public User(String name,
                String surName,
                String login,
                String psw,
                int year,
                ArrayList<Course> myEnrolledCourses,
                boolean isdModerator,
                ArrayList<Course> myAdministratedCourses,
                String bankAccount) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.psw = psw;
        this.year = year;
        this.myEnrolledCourses = myEnrolledCourses;
        this.isdModerator = isdModerator;
        this.myAdministratedCourses = myAdministratedCourses;
        this.bankAccount = bankAccount;
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

    public boolean isIsdModerator() {
        return isdModerator;
    }

    public void setIsdModerator(boolean isdModerator) {
        this.isdModerator = isdModerator;
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
        return "Labas " + name + " " + surName + " {" + login + "}";
    }
}
