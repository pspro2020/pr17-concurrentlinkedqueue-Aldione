import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Elemento {

    private final int tolvaId;
    private final int elementoId;

    public Elemento (int tolvaId, int elementoId){
        this.tolvaId = tolvaId;
        this.elementoId = elementoId;
        System.out.printf("%s - La %s %s ha soltado el elemento %s\n", DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()), Thread.currentThread().getName(), tolvaId, elementoId);

    }

    @Override
    public String toString() {
        return String.format("%s - La maquina separadora ha separado de la tolva %d el elemento %d", DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()), tolvaId, elementoId);
    }
}
