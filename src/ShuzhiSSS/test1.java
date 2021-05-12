package ShuzhiSSS;
/**
 * @author lwm
 * @create 2020-11-22-20:55
 */
public class test1 {
    public static void main(String[] args) {
        double a = 0;
        for (double n = 0; n < 17; n++) {
            if (n==0||n==16){
                double x = (1.0/16.0)*n;
                a += init(x);
            }else{
                double x = (1.0/16.0)*n;
                a += 2*init(x);
            }
        }
        a = a*1/32;
        System.out.print("(1)");
        System.out.println("梯形："+a);
        double x = 0;
        a = 0;
        for (double i = 0; i < 17; i++) {
            if (i==0||i==16){
                x = (1.0/16.0)*i;
                a += init(x);
            }else if (i%2==1){
                x = (1.0/16.0)*i;
                a += 4*init(x);
            }else{
                x = (1.0/16.0)*i;
                a += 2*init(x);
            }
        }
        a = a*1/48;
        System.out.println("   辛普森："+a);
        double b = 0;
        double m = Math.PI*1/6;
        for (double n = 0; n < 33; n++) {
            if (n==0||n==32){
                x = (1.0/32.0)*n*m;
                b += init1(x);
            }else{
                x = (1.0/32.0)*n*m;
                b += 2*init1(x);
            }
        }
        b = b*1/64*m;
        System.out.println("---------------------------------------");
        System.out.print("(2)");
        System.out.println("梯形："+b);
        b = 0;
        for (double i = 0; i < 33; i++) {
            if (i==0||i==32){
                x = (1.0/32.0)*i*m;
                b += init1(x);

            }else if (i%2==1){
                x = (1.0/32.0)*i*m;
                b += 4*init1(x);

            }else{
                x = (1.0/32.0)*i*m;
                b += 2*init1(x);

            }
        }
        b = b*1/96*m;
        System.out.println("   辛普森："+b);
    }

    private static double init(double x) {
        return x/(4+x*x);
    }
    private static double init1(double x) {
        return Math.sqrt(4-Math.sin(x)*Math.sin(x));
    }
}
class A {

}
