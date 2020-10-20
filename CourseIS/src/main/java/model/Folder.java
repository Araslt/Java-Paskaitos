package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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
        return "Folder{" +
                "folderName='" + folderName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
