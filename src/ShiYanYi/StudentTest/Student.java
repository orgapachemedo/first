package ShiYanYi.StudentTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * @auther lwm
 * @Time 2020 - 09 - 15 - 20:43
 */
public class Student {
    private int Sno ;
    private String PhoneNumber,Name , Sex , Birth , Grade ,Email;

    public Student(int sno, String name, String sex,String birth, String grade,String phoneNumber ,  String email) {
        Sno = sno;
        PhoneNumber = phoneNumber;
        Name = name;
        Sex = sex;
        Birth = birth;
        Grade = grade;
        Email = email;
    }

    public Student() {
    }



    @Override
    public int hashCode() {
        return Objects.hash(Sno);
    }

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    @Override
    public String toString() {
        return "Student{" +
                "学号=" + Sno +
                ", 姓名='" + Name + '\'' +
                ", 性别='" + Sex + '\'' +
                ", 生日='" + Birth + '\'' +
                ", 班级='" + Grade + '\'' +
                ", 电话号码=" + PhoneNumber +
                ", Email='" + Email + '\'' +
                '}';
    }

}
