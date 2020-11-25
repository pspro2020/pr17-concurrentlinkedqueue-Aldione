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
            crearYSoltarElementos(tolvaId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void crearYSoltarElementos(int tolvaId) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            soltarElemento(tolvaId, i+1);
        }
    }

    private void soltarElemento(int tolvaId, int elementoId) throws InterruptedException {
        cinta.soltarElemento(tolvaId, elementoId);
    }
}
