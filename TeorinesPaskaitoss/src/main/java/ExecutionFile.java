import ds.Person;
import subclasses.Lecturer;

public class ExecutionFile {
    public static void main(String[] args) {
        Person p = new Person();            //Person klase yra public, todel galima sukurti si objecta
        Person p2 = new Person("Vardas", "Pavarde", 1974);

        System.out.println(p.name + " " + p.getSurName() + " " + p.getBirthYear());

        System.out.println(p.getAge());
        p.greet();

        //System.out.println(p.calculateSum(12,13));      //jei metodas yra aprasytas klaseje be static
        System.out.println(Person.calculateSum(12, 3)); // ojectas nera sukuriamas, bet paskaiciavimas veikia

        System.out.println(Person.animal);  //aprasyta klaseje taip: public static String animal = "Human";

        System.out.println(p.animal);
        Person.animal = "Zebra";
        System.out.println(p2.animal);

        Lecturer ddd = new Lecturer();

    }
}
