package model;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CourseFile implements Serializable {

    private String fileName;
    private int fileSize;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    private String fileType;
    private File file;

    public CourseFile(String fileName, int fileSize, LocalDate dateCreated, LocalDate dateModified, String fileType, File file) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.fileType = fileType;
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "CourseFile{" +
                "fileName=" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", fileType=" + fileType + '\'' +
                ", file=" + file +
                '}';
    }

    public static void manageCourseFile(Scanner scanner, CourseIS courseIS, User user) {
        String fileCmd = "";
        while (!fileCmd.equals("back")) {
            System.out.println("main/course/file/ \n" +
                    "\t add - add file to a course \n" +
                    "\t upd - update the file \n" +
                    "\t del - remove the file \n" +
                    "\t print - print all files \n" +
                    "\t back - return to course \n");
            fileCmd = scanner.next();

            switch (fileCmd) {
                case "add":
                    addFile(scanner, courseIS);
                    break;
                case "upd":
                    updateFile(scanner, courseIS);
                    break;
                case "del":
                    deleteFile(scanner, courseIS);
                case "print":
                    System.out.println("Enter course title");
                    String kursoPavadinimas = scanner.next();
                    Course course = courseIS.getAllCourses().stream().filter(course1 -> course1.getCourseName().equals(kursoPavadinimas)).findFirst().orElse(null);
                    if (course != null) {
                        course.getCourseFiles().forEach(courseFile -> System.out.println(courseFile.toString()));
                        break;
                    }
                    break;
                case "back":
                    System.out.println("going up \n");
                    break;
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private static CourseFile getCourseFileByName(ArrayList<CourseFile> courseFiles, String failoPavadinims) {
        return courseFiles.stream().filter(file -> file.getFileName().equals(failoPavadinims)).findFirst().orElseGet(null);
    }

    public static void addFile(Scanner scanner, CourseIS courseIS) {

        System.out.println("Kokiam kursui irasyti faila?");
        String kursoPavadinimas = scanner.next();

        Course course = Course.getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);

        if (course != null) {
            System.out.println("Enter file name \n" +
                    "{FileName} \n");
            String[] values = scanner.next().split(";");

            File myObj = new File("D:\\JavaApp");
            String txt = "txt";

            System.out.println("Pridetas failas: ");
            course.getCourseFiles().add(new CourseFile(values[0],
                    1,
                    LocalDate.now(),//LocalDate.parse(values[2]),   //datecreated
                    LocalDate.now(),//LocalDate.parse(values[3]),   //datemodified
                    txt,
                    myObj
            ));
        }
        course.getCourseFiles().forEach(file -> System.out.println(file.toString()));
    }

    public static void updateFile(Scanner scanner, CourseIS courseIS) {
        System.out.println("Enter course name? \n");
        String kursoPavadinimas = scanner.next();
        Course course = Course.getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);

        if (course != null) {
            System.out.println("Enter file name? \n");
            String failoPavadinimas = scanner.next();
            CourseFile courseFile = CourseFile.getCourseFileByName(course.getCourseFiles(), failoPavadinimas);
            if (courseFile != null) {
                System.out.println("Update {title};{size};{date created};{date modified};{txt};{path} - ;-; - jei nekeiciam");
                String[] values = scanner.next().split(";");
                if (!values[0].equals("-")) {
                    courseFile.setFileName(values[0]);
                }
                if (!values[1].equals("-")) {
                    courseFile.setFileSize(1);
                }
                if (!values[2].equals("-")) {
                    courseFile.setDateCreated(LocalDate.parse(values[2]));
                }
                if (!values[3].equals("-")) {
                    courseFile.setDateModified(LocalDate.parse(values[3]));
                }
                if (!values[4].equals("-")) {
                    courseFile.setFileType(values[4]);
                }
                if (!values[5].equals("-")) {
                    courseFile.setFile(new File(values[5]));
                }
            }
        }
    }

    public static void deleteFile(Scanner scanner, CourseIS courseIS) {
        courseIS.getAllCourses().forEach(course -> System.out.println(course.toString()));

        System.out.println("Enter the course title \n");
        String kursoPavadinimas = scanner.next();
        Course course = Course.getCourseByName(courseIS.getAllCourses(), kursoPavadinimas);

        if (course != null) {
            System.out.println("Enter file name");
            String failoPavadinimas = scanner.next();
            CourseFile courseFile = CourseFile.getCourseFileByName(course.getCourseFiles(), failoPavadinimas);

            if (courseFile != null) {
                course.getCourseFiles().remove(courseFile);
            } else {
                System.out.println("neissitrina, nes nera");
            }
        }
    }
}
