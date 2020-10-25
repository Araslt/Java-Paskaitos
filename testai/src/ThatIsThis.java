/**
 * @uthor Ami Mince
 */

public class ThatIsThis {

    static class ZmogausKlase {
        String name;
        int age;

        public void setName(String vartaiProKurAteinaReiksme) {
            name = vartaiProKurAteinaReiksme;               // be this, nes kitas parametro vardas
        }

        public void setAge(int age) {
            this.age = age;                 // su this, kad nesidubliuotu klases ir metodo parametro vardai
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void getInfo() {
            System.out.println(name + " " + age);
        }

    }
}
