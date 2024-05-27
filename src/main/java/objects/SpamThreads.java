package objects;

import java.util.Random;

public class SpamThreads implements Runnable {

    String name;

    public SpamThreads(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(new Random().nextInt(1001));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println( name + " вывел: " + i);
        }
    }
}
