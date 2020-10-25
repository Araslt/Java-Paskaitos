import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Ami Mince
 */

public class ArrayListas {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        //head -> [6] -> [5] -> [3] -> [4] -> [7]       mazgai

        List<Integer> arrayList = new ArrayList<>();
        //[1] [2] [3] [4] [5]           masyvas

        measureTime(linkedList);
        measureTime(arrayList);

    }

    private static void measureTime(List<Integer> list) {

/*        for (int i = 0; i < 10000; i++) {             //ciklas tarp start ir end skaiciuoja pridejimu laika
            list.add(i);                                //viskas vyksta i eilute pabaiga is eiles
        }

            for (int i = 0; i < 10000; i++) {             //ciklas tarp start ir end skaiciuoja nuskaitymu laika
                list.get(i);                                //viskas vyksta i eilute pabaiga is eiles
            }*/

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {             //ciklas tarp start ir end skaiciuoja pridejimu laika
            list.add(0, i);                      //viskas vyksta i eilute pradzia, skirtumas didelis linkedListo naudai
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
