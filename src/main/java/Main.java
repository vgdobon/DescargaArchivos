import sun.security.krb5.internal.crypto.Des;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args)  {

        List<Descarga> descargas = new ArrayList<Descarga>();

        Descarga descarga1= new Descarga("http://mirrors.kernel.org/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb","descarga1.deb");
        Descarga descarga2= new Descarga("http://ftp.osuosl.org/pub/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb","descarga2.deb");
        Descarga descarga3= new Descarga("http://za.archive.ubuntu.com/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb","descarga3.deb");
        
        descargas.add(descarga2);
        descargas.add(descarga3);
        descargas.add(descarga1);

        Gestor gestor = new Gestor();

        descargas= gestor.comenzarDescarga(descargas);

        for (Descarga descarga : descargas) {
            if(descarga.getTiempoTotal()>60000){
                System.out.println("La descarga del archivo: " + descarga.fileName + " ha excedido el tiempo de descarga. ");
            }
        }

        DescargaComparador descargaComparador = new DescargaComparador();
        descargas.sort(descargaComparador);

        int nArchivo=1;



        for (Descarga descarga : descargas) {
            System.out.println(nArchivo + ": " + descarga.fileName + " descargado en " + descarga.getTiempoTotal()/1000f + " segundos.");
            nArchivo++;

        }
    }
}
