package ShiYanEr.ExceptionTest;
/**
 * @auther lwm
 * @Time 2020 - 09 - 29 - 16:03
 */
public class people  {
    public void printLetter(char c) throws NoLowerLetter{
        if ( Character.isUpperCase(c) ){
            throw new NoLowerLetter("无小写字母！");
        }
        else {
            System.out.println(c);
        }
    }
    public void printDigit(char c) throws NoDigit{
        if (!Character.isDigit(c)){
            throw  new NoDigit("无数字！");
        }
        else {
            System.out.println(c);
        }
    }
    public static void main(String[] args) throws NoDigit, NoLowerLetter {
        people people = new people();
        people.printDigit('1');
        people.printLetter('w');
    }
}
