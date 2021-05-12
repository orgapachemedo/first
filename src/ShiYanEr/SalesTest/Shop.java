package ShiYanEr.SalesTest;
import java.util.ArrayList;
/**
 * @auther Medo
 * @Time 2020 - 09 - 29 - 18:03
 */
public class Shop {
    private ArrayList<ComputeTotalSales> computeTotalSales;
    public Shop(ArrayList<ComputeTotalSales> computeTotalSales) {
        this.computeTotalSales = computeTotalSales;
    }
    public static void main(String[] args) {
        ArrayList<ComputeTotalSales> arrayList = new ArrayList<>();
        arrayList.add(new Television());
        arrayList.add(new Mobile());
        arrayList.add(new Computer());
        Shop shop = new Shop(arrayList);
        shop.show();
    }
    private void show() {
        double sum = 0 ;
        for (int i = 0; i <computeTotalSales.size() ; i++) {
            sum += computeTotalSales.get(i).totalSalesByYear();
        }
        System.out.println("年销售额：" + sum);
    }
}
