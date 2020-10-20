package ds;

import java.time.Year;

public class Person {                       //jei klase butu dar ir final, kitos klases negaletu jos paveldeti
    //jei abstracti - negalima butu kitose klasese sukurti objekto
    public static String animal = "Human";  //static - reiskia klases kintamasis o ne objekto
    public String name;                     //klase prieinama kitoms klasems
    private String surName;                 //Atributai, konstruktoriai ir metodai pasiekiami tik klasės viduje;
    protected int birthYear;                 //Atributai, konstruktoriai ir metodai pasiekiami tik tam pačiam pakete esančioms klasėms arba subklasėms;

    public Person() {                       //apsirasom konstruktoriu
        System.out.println("create a person with default values");
        //objecto kurimo metu priskiriam defaultines reiksmes
        this.name = "Name";
        this.surName = "Surname";
        this.birthYear = 1900;
    }

    //sukuriame construktoriu ir nurodome parametrus
    public Person(String name, String surName, int birthDay) {
        this.name = name;
        this.surName = surName;
        this.birthYear = birthDay;
    }

    public void greet() {
        System.out.println("Hello Human. ");
    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

    public static int calculateSum(int a, int b) {     //static, reiskia metodas yra ne objecto o klases
        return a + b;                                   //ji issikviesim nesukure objekto
    }

    public static String getAnimal() {
        return animal;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static void setAnimal(String animal) {
        Person.animal = animal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


}
