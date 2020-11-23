import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Cinta cinta = new Cinta();
        Thread[] tolvaThread = new Thread[5];

        for (int i = 0; i < tolvaThread.length; i++) {
            tolvaThread[i] = new Thread(new Tolva(cinta, i+1), "Tolva");
            tolvaThread[i].start();
        }

        TimeUnit.SECONDS.sleep(3);
        cinta.separador();
    }

}
