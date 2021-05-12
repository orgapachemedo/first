package ShiYanSi;


import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author lwm
 * @create 2020-10-29-10:21
 */
public class zhan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }
}
