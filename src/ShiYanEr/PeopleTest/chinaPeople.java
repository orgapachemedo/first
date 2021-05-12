package ShiYanEr.PeopleTest;
/**
 * @auther lwm
 * @Time 2020 - 09 - 29 - 14:19
 */
public class chinaPeople extends People {
    public chinaPeople(double h , double w) {
        super(h,w);
        this.speakHello();
        this.averageHeight();
        this.averageWeight();
        this.chinaGongfu();
    }

    public chinaPeople() {
        super();
    }

    @Override
    public void speakHello(){
        System.out.println("中国人说你好");
    }

    @Override
    public void averageHeight() {
        System.out.println("中国人的平均身高：" + super.getHeight());
    }

    @Override
    public void averageWeight() {
        System.out.println("中人的平均体重：" + super.getWeight());
    }
    public  void chinaGongfu(){
        System.out.println("功夫");
    }

    public void setWeight(double a){
        super.setWeight(a);
    }
    public void setHeight(double a){
        super.setHeight(a);
    }
}
