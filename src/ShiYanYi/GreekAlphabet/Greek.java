package ShiYanYi.GreekAlphabet;

/**
 * @auther lwm
 * @Time 2020 - 09 - 15 - 19:26
 */
public class Greek {
    public static void main(String[] args) {
        char a = 'α' ;
        for (int i = a; i <a + 25 ; i++) {
            if (i % 10 == 0 ){
                System.out.println();
            }
            System.out.print((char) i + " ");
        }
    }
}
