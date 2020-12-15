package utils;

import model.CourseIS;

import java.io.*;
import java.util.Arrays;

public class FileIO {

    public static CourseIS ReadCourseFromDBFile(CourseIS courseIS) {

        try {
            FileInputStream fis = new FileInputStream("db.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            courseIS = (CourseIS) ois.readObject();
            System.out.println(Arrays.toString(new CourseIS[]{courseIS}));

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Kazkas ce ne taip!\n");
        }
        return courseIS;
    }

    public static void WriteCourseToDBFile(CourseIS courseIS) {

        File failiukas = new File("db.bin");

        try {
            FileOutputStream fos = new FileOutputStream(failiukas);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(courseIS);
            oos.close();

        } catch (IOException e) {
            System.out.println("Kazkas ce niapaviko!\n");
        }
    }

}
