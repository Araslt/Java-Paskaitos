import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @uthor Ami Mince
 */

public class Exception1 {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("exceptionas metode main");
        }
    }

    public static void readFile() throws FileNotFoundException {
        File file = new File("people.bin");
        Scanner scanner = new Scanner(file);
    }

}
