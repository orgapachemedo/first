package ShiYanSi;


import java.util.*;

/**
 * @author lwm
 * @create 2020-10-29-10:04
 */
public class Stu {
    private String name,age;
    private long sno;

    public Stu(String name, long sno, String age) {
        this.name = name;
        this.sno = sno;
        this.age = age;
    }

    public long getSno() {
        return sno;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sno=" + sno +
                '}';
    }

    public static void main(String[] args) {
        List stu = new ArrayList();
        stu.add(new Stu("lxq",20185255,"20"));
        for (int i = 0; i < 3; i++) {
            stu.add(new Stu("lwm" + i,20185253 + i,"20"));
        }
        stu.add(new Stu("mb",20185251,"20"));
        stu.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Stu stu1 = (Stu) o1;
                Stu stu2 = (Stu) o2;
                return stu1.getSno()>stu2.getSno()? 1:-1;
            }
        });
        Iterator iterator = stu.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
