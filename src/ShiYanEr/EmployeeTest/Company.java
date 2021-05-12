package ShiYanEr.EmployeeTest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @auther lwm
 * @Time 2020 - 09 - 29 - 14:52
 */
public class Company {
    private ArrayList<Employee> employee;
    public Company(ArrayList<Employee> employee) {
        this.employee = employee;
    }
    public void showall(){
        System.out.println("年工资总额：" + earn());
    }
    private double earn() {
        Iterator iterator = employee.iterator();
        double sum = 0 ;
        for (int i = 0; i <employee.size() ; i++) {
            sum += employee.get(i).earnings();
        }
        return sum;
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        ArrayList<Employee> employe = new ArrayList<>();
        employe.add(new WeakWorker(700));
        employe.add(new MonthWorker(20000));
        employe.add(new YearWorker(500000));

        Company company = new Company(employe);
        company.showall();
    }
    }

