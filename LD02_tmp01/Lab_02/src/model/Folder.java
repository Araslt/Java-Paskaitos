package model;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Folder implements Serializable {

    private String folderName;
    private LocalDate creationDate;
    private LocalDate modifyDate;
    private ArrayList<CourseFile> filesInFolder;

    public Folder(String folderName, LocalDate creationDate, LocalDate modifyDate, ArrayList<CourseFile> filesInFolder) {
        this.folderName = folderName;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.filesInFolder = filesInFolder;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public ArrayList<CourseFile> getFilesInFolder() {
        return filesInFolder;
    }

    public void setFilesInFolder(ArrayList<CourseFile> filesInFolder) {
        this.filesInFolder = filesInFolder;
    }

    @Override
    public String toString() {
        return "Folderis " + folderName + " " + creationDate + " {" + modifyDate + "}" + " {" + filesInFolder + "}";
    }

    public static void manageCourseFolders(Scanner scanner, CourseIS courseIS, User user) {

        String folderCmd = "";

        while (!folderCmd.equals("back")) {
            System.out.println("main/course/folders/  \n" +
                    "\t add - add folder \n" +
                    "\t upd - update folder \n" +
                    "\t del - delete folder \n" +
                    "\t print - print folders \n" +
                    "\t back - return to main menu \n");
            folderCmd = scanner.next();
            switch (folderCmd) {
                case "add":
                    addFolder(scanner, courseIS);
                    break;
                case "upd":
                    updateFolder(scanner, courseIS);
                    break;
                case "del":
                    deleteFolder(scanner, courseIS, user);
                    break;
                case "print":
                    courseIS.getAllCourses().forEach(course -> System.out.println(course.toString()));
                    break;
                case "back":
                    System.out.println("going up");
                    break;
            }
        }
    }


    private static Folder getCourseFolderByName(ArrayList<Folder> courseFolder, String folderioPavadinims) {
        return courseFolder.stream().filter(file -> file.getFolderName().equals(folderioPavadinims)).findFirst().orElseGet(null);
    }

    public static void addFolder(Scanner scanner, CourseIS courseIS) {

        System.out.println("Kokiam kursui irasyti folderi?");
        String kursoPavadinimas = scanner.next();

        Course course = Course.getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);

        if (course != null) {
            System.out.println("Enter folder info: {FolderName} \n");
            String[] values = scanner.next().split(";");

            System.out.println("Pridetas folderis: " + values[0] + " \n");
            course.getCourseFolders().add(new Folder(values[0],
                    LocalDate.now(),//LocalDate.parse(values[1]),   //datecreated
                    LocalDate.now(),//LocalDate.parse(values[2]),   //datemodified
                    new ArrayList<CourseFile>()));
        }
    }

    public static void updateFolder(Scanner scanner, CourseIS courseIS) {
        System.out.println("Enter course name to update folder: \n");
        String courseName = scanner.next();

        Course course = Course.getCourseByName(courseIS.getAllCourses(), courseName);

        if (course != null) {
            System.out.println("Enter folder name to update:\n");
            String folder = scanner.next();

            Folder courseFolder = Folder.getCourseFolderByName(course.getCourseFolders(), folder);

            if (courseFolder != null) {
                System.out.println("Update {FolderName};{Folder dateCreated};{Folder dateModified};{Folder Files} - ;-; - jei nekeiciam");
                String[] values = scanner.next().split(";");
                if (!values[0].equals("-")) {
                    courseFolder.setFolderName(values[0]);
                }
                if (!values[1].equals("-")) {
                    courseFolder.setCreationDate(LocalDate.parse(values[1]));
                }
                if (!values[2].equals("-")) {
                    courseFolder.setModifyDate(LocalDate.parse(values[2]));
                }
                if (!values[3].equals("-")) {
                    courseFolder.setFilesInFolder(new ArrayList<CourseFile>());
                }
            }
        }
    }

    public static void deleteFolder(Scanner scanner, CourseIS courseIS, User user) {
        courseIS.getAllCourses().forEach(course -> System.out.println(course.toString()));

        System.out.println("Enter course title: \n");
        String name = scanner.next();

        Course course = Course.getCourseByName(courseIS.getAllCourses(), name);

        ArrayList<User> users = new ArrayList<User>();
        users.add(user);

        if (course != null) {
            System.out.println("Enter folder name: \n");
            String folder = scanner.next();
            Folder courseFolder = Folder.getCourseFolderByName(course.getCourseFolders(), folder);
            if (courseFolder != null) {
                course.getCourseFolders().remove(courseFolder);
            } else {
                System.out.println("neissitrina, nes nera \n");
            }
        }
    }
}
