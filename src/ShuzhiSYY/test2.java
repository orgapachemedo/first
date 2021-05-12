package ShuzhiSYY;
/**
 * @auther lwm
 * @Time 2020 - 11 - 05 - 21:29
 */
public class test2 {
    public static void main(String[] args) {
        double x = 4.0;
        for (int i = 1; i <= 10; i++) {
            x = method(x);
            System.out.println("x"+i+":"+x);
        }
    }
    private static double method(double x) {
        return (4+3/2*Math.cos(x));
    }
}
