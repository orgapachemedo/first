package shuzhi;

public class test1 {
    static double h = 0.1;
    public static void main(String[] args) {
        double hh = 0;
        double y = 0;
        double z = 0;
        int sum = 0;
        System.out.println("显示欧拉法：");
        while (hh<=1){
            y = f1(hh,y);
            System.out.println("y"+sum+"="+y);
            sum++;
            hh = hh+0.1;
        }
        hh = 0;
        y = 0;
        sum = 0;
        System.out.println("--------------------------");
        System.out.println("隐式欧拉法：");
        while (hh < 1.0){
            z = f1(hh,z);
            hh = hh+0.1;
            y = f2((hh),y,z);
            System.out.println("y"+sum+"="+y);
            sum++;
        }
        hh = 0;
        sum = 0;
        double yp = 0;
        double yc = 0;
        System.out.println("--------------------------");
        System.out.println("改进欧拉法：");
        while (hh < 1.0){
          yp = f1(hh,yp);
          hh = hh+h;
          yc = f3(hh,yc,yp);
            System.out.println("y"+sum+"="+(0.5)*(yp+yc));
            sum++;
        }
    }

    private static double f1(double x,double y) {
        return (y+h*(x*x+x-y));
    }
    private static double f2(double x,double y,double z){
        return (y+h*(x*x+x-z));
    }
    private static double f3(double x,double y,double z){
        return (y+h*(x*x+x-z));
    }
}
