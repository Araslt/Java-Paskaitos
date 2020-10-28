import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class Generics2 {
    public static void main(String[] args) {

        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        test(listOfDogs);
        test(listOfAnimal);
    }

    private static void test(List<? extends Animal> listikas) {     //wildcard - kad metodas galetu naudotis ir dukterinemis klasemis
        for (Animal animalcikas : listikas) {                       // jei butu ne extends o super, tai naudotusi tevinemis klasemis
            animalcikas.eat();

        }
    }
}
