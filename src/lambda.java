import java.util.Random;

/**
 * @mi mosaica
 */

public class lambda {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello"));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");

            }
        });

    }
}

