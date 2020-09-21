import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class Descarga extends Thread{

    String fileUrl;
    String fileName;
    long tiempoTotal;

    public Descarga(String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = "Descargas/" + fileName;
    }

    public void run(){

        long tiempoInicial = System.currentTimeMillis();
        ReadableByteChannel readableByteChannel = null;
        try {


            readableByteChannel = Channels.newChannel(new URL(this.fileUrl).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            FileChannel fileChannel = fileOutputStream.getChannel();
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

            long tiempoFinalDescarga= System.currentTimeMillis();
            tiempoTotal = ( tiempoFinalDescarga-tiempoInicial );

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    public long getTiempoTotal() {
        return tiempoTotal;
    }
}
