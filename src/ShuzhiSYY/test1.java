package ShuzhiSYY;

/**
 * @auther lwm
 * @Time 2020 - 11 - 05 - 20:39
 */

public class test1 {
    public static void main(String[] args) {
        double a = -5,b = 5;
        double i = 0.1;
        double c = -4.9;
        while (c < b){
            if (method2(a)*method2(c)<0){
                method1(a,c);
                c = c+i;
                a = a+i;
            }else {
                c = c+i;
                a = a+i;
            }
        }
    }
    private static void method1 (double a, double b){
        while (Math.abs(b-a)>0.000001){
            if (method2(a)*method2(b)<0) {
                double L = (a + b) / 2;
                if (method2(L) * method2(a) < 0) {
                    method1(a, L);
                } else {
                    method1(b, L);
                }
            }
            if (Math.abs(b-a)>0.000001){
                return;
            }
        }
        System.out.println("区间["+a+","+b+"]");
        System.out.println("值："+method2((a+b)/2));
    }
        private static double method2 ( double x){
            return  (x * x * x - 1.8 * x * x + 0.15 * x + 0.65);
        }
}
