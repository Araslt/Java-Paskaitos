import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Period;

/**
 * @uthor Ami Mince
 */

public class WriteObject {
    public static void main(String[] args) {
        Persona persona1 = new Persona(1, "Ami");
        Persona persona2 = new Persona(2, "Lina");

        try {
            FileOutputStream fos = new FileOutputStream("people.bin");  //sukuriam serializacijos objecta - jis irasoo viska - piesiniai garsas tt
            ObjectOutputStream oos = new ObjectOutputStream(fos);       //sitas iraasineja jau objektus, konkreciau

            oos.writeObject(persona1);
            oos.writeObject(persona2);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
