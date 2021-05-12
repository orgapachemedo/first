package ShuzhiSYY;
/**
 * @auther lwm
 * @Time 2020 - 11 - 06 - 20:09
 */

public class test3 {
    public static void main(String[] args) {
        double x = 0.5;
        test3 test = new test3();
        System.out.println("牛顿迭代");
        for (int i = 1; i < 40; i++) {
            x = test.diedai1(x);
            System.out.print("x"+i+":" + "  "+ x + "\t");
            if ( i % 4 == 0 ){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("修正的牛顿迭代");
        x = 0.5;
        for (int i = 1; i<10;i++){
            x = test.diedai2(x);
            System.out.println("x"+i+":" + "  "+x);
        }
    }


    public double ds1(double x){
        return 4*x+2-2*Math.pow(Math.E,2*x);
    }
    public double ds2(double x)
    {
        return 4-4*Math.pow(Math.E,2*x);
    }
    public double hanshu(double x)
    {
        return 2*x*x+2*x+1-Math.pow(Math.E,2*x);

    }
    public double diedai1(double x){
        test3 text3 = new test3();
        return x-(text3.hanshu(x)/text3.ds1(x));
    }
    public double diedai2(double x){
        test3 text3 = new test3();
        return x-(text3.ds1(x)*text3.hanshu(x))/(text3.ds1(x)*text3.ds1(x)-text3.hanshu(x)*ds2(x));
    }
}
