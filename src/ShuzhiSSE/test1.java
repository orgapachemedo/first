package ShuzhiSSE;
/**
 * @auther lwm
 * @Time 2020 - 11 - 11 - 20:19
 */
public class test1 {
    double a = 0.4846555; double a1 = 0.46;
    double b = 0.4937452; double b1 = 0.47;
    double c = 0.5027498; double c1 = 0.48;
    double d = 0.5116683; double d1 = 0.49;
    double fx = 0.5;
    public static void main(String[] args) {

        double x = 0.472;
        double x1 = 0.47;
        double x2 = 0.48;
        test1 test1= new test1();
        System.out.println(test1.method2(x));

        method1(x1,x2);
    }

    private static void method1(double a,double b) {
        test1 test1 = new test1();
        double L = (a+b)/2;
        while (Math.abs(test1.method2(L)-test1.fx)>0.0000001){
            if (Math.abs((test1.method2(a)- test1.fx))>Math.abs((test1.method2(b)-test1.fx))){
                method1(L,b);
            }else{
                method1(L,a);
            }
            if (Math.abs(test1.method2((a+b)/2)-test1.fx)>0.0000001){
                return;
            }
        }
        System.out.println(L);
    }

    private double method2(double x){
        return (a*(x-b1)*(x-c1))/((a1-b1)*(a1-c1))+(b*(x-a1)*(x-c1))/((b1-a1)*(b1-c1))+(c*(x-a1)*(x-b1))/((c1-a1)*(c1-b1));
    }
}
