package ShiYanYi.Exe3Test;

/**
 * @auther lwm
 * @Time 2020 - 09 - 15 - 20:08
 */
public class Trangle {
    private double a,b,c;
    private double S,C;
    private boolean isRight;

    public double getS() {
        if(isTrangle()){
            double p = (a+b+c)/2;
            S = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            System.out.println("此三角形面积为：" + S);
        }else{
            System.out.println("不是一个三角形,不能计算面积");
        }
        return S;
    }

    public double getC() {
        if(isTrangle()){
            C = a + b + c ;
            System.out.println("此三角形周长为：" + C);
        }else{
            System.out.println("不是一个三角形,不能计算周长");
        }
        return C;
    }

    public void setA(double a) {
        this.a = a;
        if(isTrangle()){
            System.out.println("可以构成三角形");
        }else{
            System.out.println("不是一个三角形");
        }
    }

    public void setB(double b) {
        this.b = b;
        if(isTrangle()){
            System.out.println("可以构成三角形");
        }else{
            System.out.println("不是一个三角形");
        }
    }

    public void setC(double c) {
        this.c = c;
        if(isTrangle()){
            System.out.println("可以构成三角形");
        }else{
            System.out.println("不是一个三角形");
        }
    }

    public Trangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }
    public boolean isTrangle(){
        if((a+b)>c&&(a+c)>b&&(b+c)>a){
            this.isRight = true ;

        }else{
            this.isRight = false;
                    }
        return isRight;
    }

    public Trangle() {
    }
}
