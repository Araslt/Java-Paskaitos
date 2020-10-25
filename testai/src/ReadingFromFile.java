import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author Ami Mince
 */

public class ReadingFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        String sepas = File.separator;
        String pathToFile = "D:"+sepas+"JavaApp"+sepas+"testai"+sepas+"tekstai.txt";

        File failiuks = new File(pathToFile);

        Scanner scr = new Scanner(failiuks);
        while (scr.hasNextLine()) {
            System.out.println(scr.nextLine());
        }
        scr.close();

/*        Scanner scr = new Scanner(System.in);
        String input = scr.nextLine();*/
    }
}
