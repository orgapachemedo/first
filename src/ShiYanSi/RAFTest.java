package ShiYanSi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author lwm
 * @create 2020-10-29-21:01
 */
public class RAFTest {
    private static final String url = "E:\\UniversityJava\\src\\ShiYanSi\\basictype.txt";
    private static final String[] model = {"r", "rw", "rws", "rwd"};

    public static RandomAccessFile getRAFWithModelRW() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[1]);
        return raf;
    }


    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = RAFTest.getRAFWithModelRW();
        String word = "ljh";
        raf.write(word.getBytes());
    }
}