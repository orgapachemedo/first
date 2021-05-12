package ShiYanYi.Exe3Test;

/**
 * @auther Medo
 * @Time 2020 - 09 - 15 - 20:31
 */
public class ExcuteTest {
    public static void main(String[] args) {
        Trangle trangle = new Trangle(1,4,5);
        Circle circle = new Circle(2);
        Lader lader = new Lader(2,4,3);
        trangle.getC();
        trangle.getS();
        circle.getC();
        circle.getS();
        lader.getS();
    }
}
