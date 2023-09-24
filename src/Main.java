import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\JungKod\\Desktop\\src";
        String dstFolder = "C:\\Users\\JungKod\\Desktop\\dst";

        File srcDir = new File(srcFolder);

        double start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / 2;

        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        new Thread(resizer1).start();  //---> through the use of interface Runnable
//        resizer1.start();  // ----> through the use of class Tread

        File[] files2 = new File[files.length - files1.length];
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();  //---> through the use of interface Runnable
//        resizer2.start();

        new Thread(()->{
            for(int i = 0; i < 100000; i++){
                System.out.println(i);
            }
        }).start();

//        System.out.println("Duration: " + + (System.currentTimeMillis() - start) / 1000 + "c.");
    }

}
