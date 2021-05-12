package ShiYanSi;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lwm
 * @create 2020-10-29-11:55
 */
public class addRowNum {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\UniversityJava\\src\\ShiYanSi\\insertType.txt");
        File file1 = new File("E:\\UniversityJava\\src\\ShiYanSi\\addNum.txt");

        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file1);
        int len,i =2 ;
        char[] data = new char[1];
        fileWriter.write("1 ");
        while ((len = fileReader.read(data)) != -1){
            if (data[0] == '\n'){
                fileWriter.write("\n"+i+" ");
                i++;
                continue;
            }else{
                fileWriter.write(data,0,len);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
