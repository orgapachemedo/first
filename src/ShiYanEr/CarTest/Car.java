package ShiYanEr.CarTest;
import java.util.ArrayList;
/**
 * @auther lwm
 * @Time 2020 - 09 - 29 - 15:31
 */
public class Car {
    private ArrayList<ComputeWeight> computeWeights;
    private  double Max = 7000;
    private double Min = 4000;
    public Car(ArrayList<ComputeWeight> computeWeights) {
        this.computeWeights = computeWeights;
    }
    public static void main(String[] args) {
        ArrayList<ComputeWeight> computeWeights = new ArrayList<>();
        computeWeights.add(new Computer());
        computeWeights.add(new Television());
        computeWeights.add(new WashMachine());
        Car car = new Car(computeWeights);
        car.show();
    }
    private void show() {
        double rest = 0 ;
        double sum = computeWeights.get(0).computeWeight();
        for (int i = 1; i <computeWeights.size()  ; i++) {
            rest = 0;
            if (Max < sum){
                System.out.println("大车重量：" + Max);
                rest  = sum - Max;
            } else if (Max == sum){
                System.out.println("大车重量：" + Max);
            }else{
                sum = sum + computeWeights.get(i).computeWeight();
                continue;
            }
                sum = rest + computeWeights.get(i).computeWeight();
        }
            if(sum > Max){
                System.out.println("大车重量：" + Max);
                System.out.println("小车重量：" + (sum - Max));
            }else if (Max == sum){
                System.out.println("大车重量：" + Max);
            }else {
                System.out.println("小车重量：" + sum);
            }
    }
}
