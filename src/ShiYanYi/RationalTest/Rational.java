package ShiYanYi.RationalTest;

import java.util.Scanner;

/**
 * @auther lwm
 * @Time 2020 - 09 - 15 - 19:30
 */
public class Rational {
    private int Numerator;
    private int Denominator;

    public Rational(int numerator, int denominator) {
        Numerator = numerator;
        Denominator = denominator;
    }

    public int getNumerator() {
        return Numerator;
    }

    public void setNumerator(int numerator) {
        Numerator = numerator;
    }

    public int getDenominator() {
        return Denominator;
    }

    public void setDenominator(int denominator) {
        Denominator = denominator;
    }
    Rational add(Rational rational){
        int fenmu = this.Denominator * rational.getDenominator();
        int thisfenzi = this.Numerator * rational.getDenominator();
        int rfenzi = this.Denominator * rational.getNumerator();
        Rational rational1 = new Rational(thisfenzi + rfenzi, fenmu);
        return rational1;
    }
    Rational sub(Rational rational){
        int fenmu = this.Denominator * rational.getDenominator();
        int thisfenzi = this.Numerator * rational.getDenominator();
        int rfenzi = this.Denominator * rational.getNumerator();
        Rational rational1 = new Rational(thisfenzi - rfenzi, fenmu);
        return rational1;
    }
    Rational muti(Rational rational){
        int fenmu = this.Denominator * rational.getDenominator();
        int fenzi = this.Numerator * rational.getNumerator();
        Rational rational1 = new Rational(fenzi, fenmu);
        return rational1;
    }
    Rational div(Rational rational){
        int fenzi = this.Numerator * rational.getDenominator();
        int fenmu = this.Denominator * rational.getNumerator();
        Rational rational1 = new Rational(fenzi, fenmu);

        return rational1;
    }

    public Rational() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入两组分子分母： ");
        Rational rational = new Rational(in.nextInt(),in.nextInt());
        Rational rational1 = new Rational(in.nextInt(),in.nextInt());
        //相加操作
        int numerator = rational.add(rational1).getNumerator();
        int denominator = rational.add(rational1).getDenominator();
        System.out.println("有理数" + rational.getNumerator() + "/" + rational.getDenominator() + "与"
        + "有理数" + rational1.getNumerator() + "/" + rational1.getDenominator() + "的和为" + numerator + "/" + denominator);
        //相减
        numerator = rational.sub(rational1).getNumerator();
        denominator = rational.sub(rational1).getDenominator();
        System.out.println("有理数" + rational.getNumerator() + "/" + rational.getDenominator() + "与"
                + "有理数" + rational1.getNumerator() + "/" + rational1.getDenominator() + "的差为" + numerator + "/" + denominator);
        //相乘操作
        numerator = rational.muti(rational1).getNumerator();
        denominator = rational.muti(rational1).getDenominator();
        System.out.println("有理数" + rational.getNumerator() + "/" + rational.getDenominator() + "与"
                + "有理数" + rational1.getNumerator() + "/" + rational1.getDenominator() + "的积为" + numerator + "/" + denominator);
        //相除操作
        numerator = rational.div(rational1).getNumerator();
        denominator = rational.div(rational1).getDenominator();
        System.out.println("有理数" + rational.getNumerator() + "/" + rational.getDenominator() + "与"
                + "有理数" + rational1.getNumerator() + "/" + rational1.getDenominator() + "的除为" + numerator + "/" + denominator);

    }
}
