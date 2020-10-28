import java.util.ArrayList;
import java.util.List;

/**
 * @miMince
 */

public class Generics {
    public static void main(String[] args) {

        /////////// su downcastinimu ///////////////////
        List animals = new ArrayList();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");

        //--------- galima cia ideti objekta
        Animal3 ourAnimal = new Animal3();
        animals.add(ourAnimal);

        String animal = (String) animals.get(0);
        System.out.println(animal);

        ////////// su genericais //////////////////
        List<String> animals2 = new ArrayList<>();
        animals2.add("cat2");
        animals2.add("dog2");
        animals2.add("frog2");

        //ir cia nebegalime ideti bile kokio objekto
        //animals2.add(ourAnimal);

        String animal2 = animals2.get(2);
        System.out.println(animal2);
    }
}

class Animal3 {

}
