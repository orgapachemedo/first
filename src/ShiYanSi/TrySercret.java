package ShiYanSi;

import java.io.*;

/**
 * @author lwm
 * @create 2020-10-29-20:47
 */
public class TrySercret {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\UniversityJava\\src\\ShiYanSi\\basictype.txt");
        FileOutputStream fos= new FileOutputStream("E:\\UniversityJava\\src\\ShiYanSi\\basictype1.txt");
        int ch;
        System.out.println("请输入密码：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        while((ch=fis.read())!=-1){
            ch=ch^Integer.valueOf(key);
            fos.write(ch);
        }
    }
}
