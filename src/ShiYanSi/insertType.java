package ShiYanSi;

import java.io.*;

/**
 * 第三题和第4题
 * @author lwm
 * @create 2020-10-29-10:36
 */
public class insertType {
    private int anInt ;
    private double aDouble;
    private String aString;

    public insertType() {
    }

    public insertType(int anInt, double aDouble, String aString) {
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.aString = aString;
    }

    @Override
    public String toString() {
        return  anInt +
                "\n" + aDouble +
                "\n" + aString ;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\UniversityJava\\src\\ShiYanSi\\insertType.txt");
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(file,false);
        int a = 1;
        double b = 3.1415926;
        String c = "hello";
        insertType insertype = new insertType(a, b, c);
        fileWriter.write(insertype.toString());
        fileWriter.close();
        WaR(file,new File("E:\\UniversityJava\\src\\ShiYanSi\\rewrite.txt"));
    }
    public static void  WaR(File file1,File file2) throws IOException {
        FileWriter fileWriter = new FileWriter(file2,true) ;
        FileReader fileReader = new FileReader(file1) ;
        int len ;
        char cha;
        char[] chars = new char[5];
        while ((len =fileReader.read(chars)) != -1){
            fileWriter.write(chars,0,len);
        }
        fileReader.close();
        fileWriter.close();
    }
}
