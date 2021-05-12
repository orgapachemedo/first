package XinxilunSYY;

/**
 * @auther Medo
 * @Time 2020 - 10 - 06 - 14:38
 */
public class Massage implements Comparable{
    private  char Name;
    private double Rate;

    public Massage(char name, double rate) {
        Name = name;
        Rate = rate;
    }

    public Massage() {
    }

    public char getName() {
        return Name;
    }

    public void setName(char name) {
        Name = name;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    @Override
    public int compareTo(Object o) {
        Massage massage = (Massage) o;
        if (this.getRate() > massage.getRate()){
            return -1;
        }else if (this.getRate() < massage.getRate()){
            return 1;
        }else {
            return 0;
        }
    }

    public void setRaN(char count, double rateCount) {
        this.setName(count);
        this.setRate(rateCount);
    }

    @Override
    public String toString() {
        return "Massage{" +
                "Name=" + Name +
                ", Rate=" + Rate +
                '}';
    }
}
