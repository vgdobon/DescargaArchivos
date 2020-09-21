import java.util.List;

public class Gestor {


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