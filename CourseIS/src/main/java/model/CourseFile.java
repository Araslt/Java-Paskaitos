package model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class CourseFile implements Serializable {

    private String fileName;
    private int fileSize;
    private Date dateCreated;
    private Date dateModified;
    private String fileType;
    private File file;

    public CourseFile(String fileName, int fileSize, Date dateCreated, Date dateModified, String fileType, File file) {
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
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
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", dateCreated=" + dateCreated +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
