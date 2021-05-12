package ShiYanEr.EmployeeTest;
public class MonthWorker extends Employee {
    private double earn;
    public MonthWorker(double earn) {
        this.earn = earn;
    }
    @Override
    public double earnings() {
        return working();
    }
    public double working(){
        double a  = earn * 12 ;
        return a ;
    }
}
