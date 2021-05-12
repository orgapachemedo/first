package ShiYanEr.PeopleTest;
/**
 * @auther lwm
 * @Time 2020 - 09 - 29 - 14:15
 */
public class People {
    protected double height;
    protected double weight ;

    public People(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public People() {

    }

    public void speakHello(){
        System.out.println("people:hello");
    }
    public void averageHeight(){
        System.out.println("人的平均身高：" + height);

    }
    public void averageWeight(){
        System.out.println("人的平均体重：" + weight);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        chinaPeople chinaPeople = new chinaPeople(175, 70);
        System.out.println("--------------------------------");
        AmericaPeople americaPeople = new AmericaPeople(180, 71);
        System.out.println("--------------------------------");
        BeijinPeople beijinPeople = new BeijinPeople();
        beijinPeople.setHeight(175);
        beijinPeople.setWeight(75);
        beijinPeople.excute();
    }
}
