package ShiYanEr.EmployeeTest;
public class WeakWorker extends Employee {
    private double earn;
    public WeakWorker(double earn) {
        this.earn = earn;
    }
    @Override
    public double earnings() {
        return working();
    }
    public double working(){
        double a  = earn * 52 ;
        return a ;
    }
}
