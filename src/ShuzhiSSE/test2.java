package ShuzhiSSE;
/**
 * @auther lwm
 * @Time 2020 - 11 - 11 - 22:08
 */
public class test2 {
    static double a = 0;    static double a1 = 1;
    static double b = 0.1;  static double b1 = 1.32;
    static double c = 0.2;  static double c1 = 1.68;
    static double d = 0.3;  static double d1 = 2.08;
    static double e = 0.4;  static double e1 = 2.52;
    static double f = 0.5;  static double f1 = 3;
    public static void main(String[] args) {
        System.out.println("拉格朗日插值法:");
        System.out.println("中点0.05的值为："+method1(0.05));
        System.out.println("中点0.15的值为："+method1(0.15));
        System.out.println("中点0.25的值为："+method1(0.25));
        System.out.println("中点0.35的值为："+method1(0.35));
        System.out.println("中点0.45的值为："+method1(0.45));
        System.out.println("分段线性插值法");
        System.out.println("中点0.05的值为："+method2(0.05,0,0.1,1,1.32));
        System.out.println("中点0.15的值为："+method2(0.15,0.1,0.2,1.32,1.68));
        System.out.println("中点0.25的值为："+method2(0.25,0.2,0.3,1.68,2.08));
        System.out.println("中点0.35的值为："+method2(0.35,0.3,0.4,2.08,2.52));
        System.out.println("中点0.45的值为："+method2(0.45,0.4,0.5,2.52,3));

    }
   public static double method1(double x){
        return a1*((x-b)*(x-c)*(x-d)*(x-e)*(x-f))/((a-b)*(a-c)*(a-d)*(a-e)*(a-f))+
                b1*((x-a)*(x-c)*(x-d)*(x-e)*(x-f))/((b-a)*(b-c)*(b-d)*(b-e)*(b-f))+
                c1*((x-a)*(x-b)*(x-d)*(x-e)*(x-f))/((c-a)*(c-b)*(c-d)*(c-e)*(c-f))+
                d1*((x-a)*(x-b)*(x-c)*(x-e)*(x-f))/((d-a)*(d-b)*(d-c)*(d-e)*(c-f))+
                e1*((x-a)*(x-b)*(x-c)*(x-d)*(x-f))/((e-a)*(e-b)*(e-c)*(e-d)*(e-f))+
                f1*((x-a)*(x-b)*(x-c)*(x-d)*(x-e))/((f-a)*(f-b)*(f-c)*(f-d)*(f-e));
    }
    public static double method2(double x,double x0,double x1,double y0,double y1){
        return y0+((y1-y0)*(x-x0)/(x1-x0));
    }
}
