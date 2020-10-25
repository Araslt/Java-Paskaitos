import com.sun.jdi.ClassNotLoadedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @uthor Ami Mince
 */

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("people2.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Persona persona1 = (Persona) ois.readObject();
            Persona persona2 = (Persona) ois.readObject();

            System.out.println(persona1);
            System.out.println(persona2);

            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
