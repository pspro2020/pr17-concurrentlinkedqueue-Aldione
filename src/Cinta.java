import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cinta {
    ConcurrentLinkedQueue<Elemento> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public void soltarElemento(int tolvaId) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
            concurrentLinkedQueue.add(new Elemento(tolvaId, i+1));
        }
    }

    public void separador() throws InterruptedException {
        System.out.printf("%s - La maquina separadora esta en marcha\n", DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
        while(!concurrentLinkedQueue.isEmpty()){
            System.out.println(concurrentLinkedQueue.element().toString());
            concurrentLinkedQueue.remove();
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
        }
        System.out.printf("%s - La cinta esta vacia\n", DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));

    }
}
