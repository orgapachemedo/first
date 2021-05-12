package ShiYanYi.Exe3Test;

/**
 * @auther lwm
 * @Time 2020 - 09 - 15 - 20:24
 */
public class Lader {
    private double Up,Down,High,S;

    public double getS() {
        double Area = (((Up + Down) * High ) / 2) ;
        System.out.println("梯形的面积为："  + Area);
        return Area;
    }

    public Lader() {
    }

    public Lader(double up, double down, double high) {
        Up = up;
        Down = down;
        High = high;
    }
}
