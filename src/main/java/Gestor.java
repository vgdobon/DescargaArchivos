import java.util.ArrayList;
import java.util.List;

public class Gestor {


    List<Descarga> descargas = new ArrayList<>();


    public List<Descarga> comenzarDescarga(List<Descarga> descargas) {
        for (Descarga descarga :
                descargas) {
            descarga.start();

        }

        for (Descarga descarga :
                descargas) {
            try {
                descarga.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return descargas;
    }
}