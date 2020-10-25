import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @uthor Ami Mince
 */

// tesktine eilute pavercia i primityvu int masyva

public class ReadFromFileArray {
    public static void main(String[] args) throws FileNotFoundException {
        String sepas = File.separator;
        String path = "D:" + sepas + "JavaApp" + sepas + "testai" + sepas + "tekstai2.txt";

        File failiuks = new File(path);

        Scanner scr = new Scanner(failiuks);
        String line = scr.nextLine();

        String[] eilutesSkaiciai = line.split(" ");
        int[] skaiciai = new int[3];
        int counter = 0;

        for (String skaicius : eilutesSkaiciai) {
            skaiciai[counter++] = Integer.parseInt(skaicius);
        }

        System.out.println(Arrays.toString(skaiciai));

        scr.close();

    }
}
