package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Folder implements Serializable {

    private String folderName;
    private Date creationDate;
    private Date modifyDate;
    private ArrayList<CourseFile> filesInFolder;

    public Folder(String folderName, Date creationDate, Date modifyDate, ArrayList<CourseFile> filesInFolder) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
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

    public static void manageCourseFolders(Scanner scanner, CourseIS courseIS) {

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
                    addFolder();
                    break;
                case "upd":
                    updateFolder();
                    break;
                case "del":
                    deleteFolder();
                    break;
                case "print":
                    //print;
                    break;
                case "back":
                    System.out.println("going up");
                    break;
            }
        }
    }

    public static void addFolder() {

    }

    public static void updateFolder() {

    }

    public static void deleteFolder() {

    }
}
