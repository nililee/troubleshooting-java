import java.util.Random;
import java.util.logging.Logger;

public class Producer extends Thread {

    private Logger log = Logger.getLogger(Producer.class.getName());

    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            synchronized (Main.listB) {

                synchronized (Main.listA) {
                    work(r);
                }
            }
        }
    }

    private void work(Random r) {
        if (Main.listB.size() < 100) {
            int x = r.nextInt();
            Main.listB.add(x);
            log.info("Producer " + Thread.currentThread().getName() + " added value " + x
                + " to list B");
        } else {
            int x = r.nextInt();
            Main.listB.add(x);
            log.info("Producer " + Thread.currentThread().getName() + " added value " + x
                + " to list A");
        }
    }

}
