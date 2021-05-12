package ShiYanYi.Exe3Test;

/**
 * @auther lwm
 * @Time 2020 - 09 - 15 - 20:27
 */
public class Circle {
    private double R , C , S;
    private final static double PI = 3.1415926;
    public double getC() {
        double len = 2 * PI * R;
        System.out.println("圆的周长为：" + len);
        return 2 * PI * R;
    }

    public double getS() {
        double area = PI * R * R;
        System.out.println("圆的面积为：" + area);
        return  area;
    }

    public Circle() {
    }

    public Circle(double r) {
        R = r;
    }
}
