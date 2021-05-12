package ShiYanEr.PeopleTest;
public class AmericaPeople extends People {
    public AmericaPeople(double h , double w) {
        super(h,w);
        this.speakHello();
        this.averageHeight();
        this.averageWeight();
        this.AmericanBoxing();
    }
    @Override
    public void speakHello() {
        System.out.println("美国人说你好");
    }
    @Override
    public void averageWeight() {
        System.out.println("美国人的平均体重：" + super.getWeight());
    }
    @Override
    public void averageHeight() {
        System.out.println("美国人的平均身高：" + super.getHeight());
    }
    public void AmericanBoxing(){
        System.out.println("拳击");
    }
    public void setWeight(double a){
        super.setWeight(a);
    }
    public void setHeight(double a){
        super.setHeight(a);
    }
}
