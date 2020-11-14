package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Folder implements Serializable {

    private String folderName;
    private Date creationDate;
    private Date modifyDate;
    private ArrayList<CourseFile> filesInFolder;
}
