package ShiYanYi.StudentTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * @auther Medo
 * @Time 2020 - 09 - 16 - 21:29
 */
public class ExcuteStudent {
    public static void main(String[] args) {
        Collection student = new ArrayList();
        Student zyf = new Student(20185229,"张宇飞","man","2000年8月12日","计科1班","15151515151","15151515@qq.com");
        Student mb = new Student(20185256,"马斌","man","2000年12月18日","计科2班","13131313131","1113515@qq.com");
        Student lwm = new Student(20185253, "李维民", "男", "2000年3月17日", "计科2班", "12121212121", "1212121212@qq.com");
        student.add(zyf);
        student.add(mb);
        student.add(lwm);
        MethodStudent methodStudent = new MethodStudent();
        methodStudent.showall(student);
        int a ;
        while (true){
            System.out.println("1 查看通讯录；2 增加学生；3 删除学生；4 修改内容；5 退出  ");
            Scanner in = new Scanner(System.in);
            System.out.print("请输入：");
            a = in.nextInt();
        switch (a){
            case 1 :
                methodStudent.showall(student);
                break;
            case 2 :
                methodStudent.addstudent(student);
                break;
            case 3 :
                methodStudent.reMoveStudent(student);
                break;
            case 4 :
                methodStudent.modify(student);
                break;
            case 5 :
                System.exit(0);
            default:
                System.out.println("请重新输入！");
                break;
        }

    }}
}
