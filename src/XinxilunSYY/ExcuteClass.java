package XinxilunSYY;


import java.util.*;

/**
 * @auther Medo
 * @Time 2020 - 10 - 06 - 14:34
 */
public class ExcuteClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "" ;
        System.out.println("请输入信息源：");
        s = in.next();
        char[] chars = s.toCharArray();
        //数据清洗，清洗多余的数据如空格逗号之类
        char[] cha = ETLchars(chars);
        //解决乱码
        char[] counts = Count(cha);
        int lenth = counts.length;

        for (char c :
                counts) {
            System.out.print(c);
        }
        System.out.println("----------------------------------------");
        Massage[] massage = Rate(counts,lenth);
        Arrays.sort(massage, new Comparator<Massage>() {
            @Override
            public int compare(Massage massage, Massage t1) {

                return massage.getRate()<t1.getRate()? 1:-1;
            }
        });
        for (int i = 0; i <massage.length ; i++) {
            System.out.println(massage[i]);
        }
        Node node = new Node();
        SFTree(node,massage);
        node.preOrder();
    }

    private static void SFTree(Node node, Massage[] massage) {
        int size = massage.length;

        int mid = size / 2;

        int left = mid;
        if (left == 1){
            Node node1 = new Node(massage[left - 1].getName());
            node.parent = node;
            node.left = node1;
        }else {
            Node leftNode = new Node();
            Massage[] ma = new Massage[left];
            for (int i = 0; i < left; i++) {
                ma[i] = massage[i];
            }
            SFTree(leftNode, ma);
            leftNode.parent = node;
            node.left = leftNode;
        }

        int right = size - mid;
        if (right == 1){
            Node node1 = new Node(massage[size - 1].getName());
            node.parent= node;
            node.right = node1;
        }
        else {
            Node rightNode = new Node();
            Massage[] ma = new Massage[left];
            for (int i = right; i < size - right; i++) {
                ma[i] = massage[i];
            }
            SFTree(rightNode, ma);
            rightNode.parent = node;
            node.right = rightNode;
        }

    }

    private static Massage[] Rate(char[] counts,int lenth) {
        int sum = 0;
        int k = 0;
        Massage[] massage = new Massage[lenth];
        for (int i = 0; i < counts.length; i++) {
            sum = 0;
            for (int j = 0; j < counts.length; j++) {
                if (i == j ){
                    sum ++ ;
                    continue;
                }
                if (counts[i] == counts[j]){
                    sum++;
                }
            }
            massage[k] = new Massage(counts[i],rateCount(lenth,sum));
            i = i + sum -1 ;
            k++;
        }
        Massage[] massages = new Massage[k];
        for (int i = 0; i < k; i++) {
            massages[i] = massage[i];
        }
        return massages;
    }

    private static double rateCount(int lenth,int sum) {
        double A = sum*(1.0)/lenth;
        return A ;
    }

    private static char[] Count(char[] cha) {
        int k = 0 ;
        int z = 0 ;
        for (char i = 'A'; i <'z' ; i++) {
            for (int j = 0; j <cha.length ; j++) {
                if (cha[j] == i){
                    z++;
                }
            }
        }

        char[] cou = new char[z];
        for (char j = 'A'; j <'z' ; j++) {
            for (int i = 0; i <cha.length ; i++) {
                if (cha[i] == j){
                    cou[k] = cha[i];
                    k++;
                }
            }
        }
        return cou;
    }

    private static char[] ETLchars(char[] chars) {
        int j = 0;
        for (int i = 0; i <chars.length ; i++) {
            if (!(chars[i] >='A' && chars[i]<='z')){
                chars[i] = '1';
            }
        }
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i] != '1'){
                j++;
            }
        }
        int p = 0;
        char cha[] = new char[j];
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i] != '1'){
                cha[p] = chars[i];
                p++;
            }
        }
        return cha;
    }


}

