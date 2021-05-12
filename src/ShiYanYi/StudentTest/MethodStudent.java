package ShiYanYi.StudentTest;

import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @auther Medo
 * @Time 2020 - 09 - 16 - 21:29
 */
public class MethodStudent {
    static Scanner in = new Scanner(System.in);

    public  void showall(Collection arr){
        Iterator iterator = arr.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public  boolean isRightname(String s){
        if (s.length() <= 1 || s.length() >5){
            return false;
        }
        else {
            return true;
        }
    }

    public  boolean isRightBith(String s){
        if (s.length() <8  || s.length() >12){
            return false;
        }
        else {
            return true;
        }
    }
    public  boolean isRightEmail(String s){

        if (s.contains("@")){
            return true;
        }
        else {
            return false;
        }
    }
    public  boolean isRightGrade(String s){

        if (s.length() >= 3 && s.length() < 15){
            return true;
        }
        else {
            return false;
        }
    }
    public  boolean isRightSex(String s){

        if ((s.contains("man") && s.length() == 3)||(s.contains("woman") && s.length() == 5)|| (s.contains("男") &&s.length()==1)|| (s.contains("女") &&s.length()==1)){
            return true;
        }
        else {
            return false;
        }
    }
    public  boolean isRightSno(String s){

        if (s.length() == 8){
            return true;
        }
        else {
            return false;
        }
    }
    public  boolean isRightPhoneNumber(String s){

        if (s.length() == 11){
            return true;
        }
        else {
            return false;
        }
    }
    public  void addstudent(Collection arr){
        Student student = new Student();
        student.setSno(addSno());
        student.setName(addname());
        student.setSex(addSex());
        student.setGrade(addGrade());
        student.setBirth(addBirth());
        student.setPhoneNumber(addPhonenumber());
        student.setEmail(addEmail());
        arr.add(student);
        System.out.println("添加成功！");
//        return student;
    }

    public  String addname(){
        String name;
        System.out.println("请输入姓名：");
        name = in.nextLine();
        while (true){
            if (isRightname(name)){
                return name;

            }else {
                System.out.print("名字输入错误，请重新输入：");
                name = in.nextLine();
            }
        }
    }

    public String addPhonenumber() {
        String Phone;
        System.out.println("请输入电话号码：");
        Phone = in.nextLine();
        while (true){
            if (isRightPhoneNumber(Phone)){
                return Phone;

            }else {
                System.out.print("电话输入错误，请重新输入：");
                Phone = in.nextLine();
            }
        }
    }

    public int addSno() {
        String Sno;
        System.out.println("请输入8位学号：");
        Sno = in.nextLine();
        while (true){
            if (isRightSno(Sno)){
                return Integer.parseInt(Sno);

            }else {
                System.out.print("学号输入错误，请重新输入：");
                Sno = in.nextLine();
            }
        }
    }

    public   String addSex() {
        String Sex;
        System.out.println("请输入性别(中文或者英语小写)：");
        Sex = in.nextLine();
        while (true){
            if (isRightSex(Sex)){
                return Sex;

            }else {
                System.out.print("性别输入错误，请重新输入：");
                Sex = in.nextLine();
            }
        }
    }
    public   String addGrade() {
        String grade;
        System.out.println("请输入班级：");
        grade = in.nextLine();
        while (true){
            if (isRightGrade(grade)){
                return grade;

            }else {
                System.out.print("班级输入错误，请重新输入：");
                grade = in.nextLine();
            }
        }
    }

    public   String addEmail() {
        String Email;
        System.out.println("请输入邮箱：");
        Email= in.nextLine();
        while (true){
            if (isRightEmail(Email)){
                return Email;

            }else {
                System.out.print("邮箱输入错误，请重新输入：");
                Email = in.nextLine();
            }
        }
    }

    public  String addBirth() {
        String Birth;
        System.out.println("请输入生日：");
        Birth= in.nextLine();
        while (true){
            if (isRightBith(Birth)){
                return Birth;

            }else {
                System.out.print("生日输入错误，请重新输入：");
                Birth = in.nextLine();
            }
        }
    }

    public  void reMoveStudent(Collection student) {
        Student student1;
        int a = 0;
        while (true) {
            Iterator iterator = student.iterator();
            System.out.println("请输入学生学号：");
            int sno = in.nextInt();
            while (iterator.hasNext()) {
                student1 = (Student) iterator.next();
                if (student1.getSno() == sno) {
                    a = 1;
                    iterator.remove();
                    System.out.println("删除成功！");
                    break;
                }
            }
            if (a == 1){
                break;
            }else {
                System.out.println("无此学生，请重新输入！");
            }
        }
    }

    public  Collection modify(Collection student) {
        Student[] s = (Student[]) student.toArray(new Student[student.size()]);
        String name ;
        int a = 0;
        for (int i = 0; i <s.length ; i++) {
            System.out.println("请输入需要修改学生的姓名：");
            name = in.next();
            for (int j= 0; j <s.length ; j++) {
                if(s[j].getName().equals(name)){
                    s[j] = modifyattribute(s[j]);
                    a = 1;
                    break;
                }
            }
            if (a == 1){
                break;
            }else {
                System.out.println("无此学生，请重新输入！");
            }

        }

        student = Arrays.asList(s);
        return student;
    }
    public  Student modifyattribute(Student a){
        int w ;
        String s ;
        while(true){
            System.out.println("1 学号，2 姓名，3 性别，4 生日，5 班级，6 电话，7 emali，8 不修改了");
            System.out.println("请输入需要修改的属性：");
            w = in.nextInt();
            switch (w){
                case 1 :
                    System.out.println("请输入8位学号：");
                    s = in.next();
                    while (true){
                        if (isRightSno(s)){
                        a.setSno(Integer.parseInt(s));
                        System.out.println("修改成功！");
                        break;
                    }
                    else{
                        System.out.println("学号输入错误，请重新输入：");
                            s = in.next();
                    }
                    }
                    break;
                case 2:
                    System.out.println("请输入姓名：");
                    s = in.next();
                    while (true){
                        if (isRightname(s)){
                            a.setName(s);
                            System.out.println("修改成功！");
                            break;
                        }
                        else{
                            System.out.println("姓名输入错误，请重新输入：");
                            s = in.next();
                        }
                    }
                    break;
                case 3 :
                    System.out.println("请输入性别：");
                    s = in.next();
                    while (true){
                        if (isRightSex(s)){
                            a.setSex(s);
                            System.out.println("修改成功！");
                            break;
                        }
                        else{
                            System.out.println("性别输入错误，请重新输入：");
                            s = in.next();
                        }
                    }
                    break;
                case 4 :
                    System.out.println("请输入生日：");
                        s = in.next();
                    while (true){
                        if (isRightBith(s)){
                            a.setBirth(s);
                            System.out.println("修改成功！");
                            break;
                        }
                        else{
                            System.out.println("生日输入错误，请重新输入：");
                            s = in.next();
                        }
                    }
                    break;
                case 5 :
                    System.out.println("请输入班级：");
                    s = in.next();
                    while (true){
                        if (isRightGrade(s)){
                            a.setGrade(s);
                            System.out.println("修改成功！");
                            break;
                        }
                        else{
                            System.out.println("班级输入错误，请重新输入：");
                            s = in.next();
                        }
                    }
                    break;
                case 6 :
                    System.out.println("请输入电话：");
                    s = in.next();
                    while (true){
                        if (isRightPhoneNumber(s)){
                            a.setPhoneNumber(s);
                            System.out.println("修改成功！");
                            break;
                        }
                        else{
                            System.out.println("电话输入错误，请重新输入：");
                            s = in.next();
                        }
                    }
                    break;
                case 7  :
                    System.out.println("请输入email：");
                    s = in.next();
                    while (true){
                        if (isRightEmail(s)){
                            a.setEmail(s);
                            System.out.println("修改成功！");
                            break;
                        }
                        else{
                            System.out.println("email输入错误，请重新输入：");
                            s = in.next();
                        }
                    }
                    break;
                case 8 :
                   break;
                default:
                    System.out.println("请重新输入：");
                    break;
                    }
            if( w == 8 ){
                break;
            }
        }
        return a;
    }
    }

