import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class Tolva implements Runnable{

    Cinta cinta;
    private final int tolvaId;

    public Tolva(Cinta cinta, int tolvaId){
        this.cinta = cinta;
        this.tolvaId = tolvaId;
    }

    @Override
    public void run() {
        System.out.printf("%s - La %s %s se ha puesto en marcha\n", DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()), Thread.currentThread().getName(), tolvaId);
        try {
            soltarElemento(tolvaId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void soltarElemento(int tolvaId) throws InterruptedException {
        cinta.soltarElemento(tolvaId);
    }
}
