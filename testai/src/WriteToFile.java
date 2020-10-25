import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @uthor Ami Mince
 */

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        File failiukas = new File("tekstai3.txt");
        PrintWriter pw = new PrintWriter(failiukas);

        pw.println("pirma eilute");
        pw.println("äntra eilute");

        pw.close();
    }
}
