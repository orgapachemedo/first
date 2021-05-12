package ShiYanEr.PeopleTest;
public class BeijinPeople extends chinaPeople {
    public BeijinPeople() {
        super();

    }
    public void beijinOpera(){
        System.out.println("北京人的京剧");
    }
    @Override
    public void speakHello() {
        System.out.println("北京人说你好");
    }
    @Override
    public void averageHeight() {
        System.out.println("北京人的平均身高：" + super.getHeight());
    }
    @Override
    public void averageWeight() {
        System.out.println("北京人的平均体重：" + super.getWeight());
    }
    public void setWeight(double a){
        super.setWeight(a);
    }
    public void setHeight(double a){
        super.setHeight(a);
    }
    public void excute() {
        this.beijinOpera();
        this.averageHeight();
        this.averageWeight();
        this.speakHello();
    }
}
