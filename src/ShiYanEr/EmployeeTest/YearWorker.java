package ShiYanEr.EmployeeTest;
public class YearWorker extends Employee {
    private double earn;
    public YearWorker(double earn) {
        this.earn = earn;
    }
    @Override
    public double earnings() {
        return earn;
    }
}
