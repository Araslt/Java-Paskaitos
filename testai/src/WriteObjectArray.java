import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @uthor Ami Mince
 */
public class WriteObjectArray {
    public static void main(String[] args) {
        Persona[] persons = {new Persona(1, "Arunas"),new Persona(2, "Lina"),new Persona(3, "Paulina"),
                new Persona(4, "Rokas")};

        try {
            FileOutputStream fos = new FileOutputStream("people2.bin");  //sukuriam serializacijos objecta - jis irasoo viska - piesiniai garsas tt
            ObjectOutputStream oos = new ObjectOutputStream(fos);       //sitas iraasineja jau objektus, konkreciau

            oos.writeObject(persons);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
