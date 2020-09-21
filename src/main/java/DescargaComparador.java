import java.util.Comparator;

public class DescargaComparador implements Comparator<Descarga> {
    public int compare(Descarga o1, Descarga o2) {

        if(o1.getTiempoTotal() < o2.getTiempoTotal()){
            return -1;
        }
        if (o1.getTiempoTotal() > o2.getTiempoTotal()){
            return 1;
        }
        return 0;
    }
}
