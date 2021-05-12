package XinxilunSYY;

/**
 * @auther Medo
 * @Time 2020 - 10 - 07 - 14:09
 */
import java.util.*;
import javax.swing.JOptionPane;
public class TestSF {
        public static void main(String[] args) {
        shannonCode(0.19f, 0.2f, 0.18f,0.17f,0.15f,0.1f,0.01f);
        }
        public static void shannonCode(float... date) {
        StringBuffer sb=new StringBuffer();
        TreeMap<Float, String>HM = new TreeMap<Float, String>(
        Collections.reverseOrder());
        List<Float>Li = new LinkedList<Float>();
        boolean valid = numberValid(date);
        if (valid) {
        List<Float> ar = order(date);
        TreeMap<Float, Integer> hash = getLength(ar);
        Set<Float> sets = hash.keySet();// 存储了原概率。
        Li = add(ar);
        Object[] ff = sets.toArray();
        for (int i = 0; i<ff.length; i++) {
        Float pos = (Float) ff[i];
        int len = hash.get(pos);
        String str = toBin(len, Li.get(i));
        HM.put((Float) ff[i], str);
        }
        sb.append("概率    "+"      编码  ").append("\n");
        for (Map.Entry<Float, String>entry : HM.entrySet()) {
        Float probility = entry.getKey();
        String code = entry.getValue();
        sb.append("  "+probility+"            "+code+"\n");
        }
        JOptionPane.showMessageDialog(null,sb.toString(), "香农编码表：", 1);
        } else {
        JOptionPane.showConfirmDialog(null,"数字格式验证未通过，请重新输入");
        }
        }
/**
 * 检查用户输入数字是否满足概率的归一性。非负性。
 *
 * @param number
 * @return
 */
        private static boolean numberValid(float... number) {
        float sum = 0;
        for (int i = 0; i<number.length; i++) {
        if (number[i] <= 0 || number[i] >= 1) {
        return false;
        } else
        sum += number[i];
        }
        return sum == 1.0;
        }
        private static List<Float> order(float... date) {
        List<Float>li = new ArrayList<Float>();
        for (Float temp : date) {
        li.add(temp);
        }
        Collections.sort(li);
        Collections.reverse(li);
        JOptionPane.showMessageDialog(null, li.toString(), "排序后,用户输入的概率", 1);
        return li;
        }
/**
 * 计算不同概率采用香农编码后的码字长度。
 *
 * @param li
 * @return HashMap 该集合的 key 存储相应的概率 value 存数对应编码的码字长度。
 */
        private static TreeMap<Float, Integer> getLength(List<Float>li) {
        StringBuilder sb=new StringBuilder();
        int value = 0;
        Float shang = 0f;
        TreeMap<Float, Integer>tm = new TreeMap<Float, Integer>(
        Collections.reverseOrder());
        sb.append("概率").append("      ").append("编码长度").append("      ")
        .append("自信息熵").append("\n");
        for (Float temp : li) {
        shang = new Float(-(Math.log(temp)) / Math.log(2) + 1);
        value = shang.intValue();
        tm.put(temp, value);
        sb.append("  "+temp+"              "+value+"              "+shang+"\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "编码长度及信息熵", 1);
        return tm;
        }
/**
 * 计算累加概率
 *
 * @param li
 *            存储着概率的集合，集合中的元素按从大到小的顺序排列。
 * @param index
 *            对应的角标。
 * @return返回一个集合，该集合存储了，累加后的概率。
 */
        private static List<Float> add(List<Float>li) {
        List<Float>list = new ArrayList<Float>();
        for (int i = 0; i<li.size(); i++) {
        list.add(0f); // 给对于集合元素全部赋初值为：0
        }
        float temp = 0f;
        for (int i = 0; i<list.size(); i++) {
        temp = sum(li, i);
        list.set(i, temp);
        temp = 0f;
        }
        li.clear();
        li.addAll(list);
        return li;
        }
/**
 * 该函数可以实现，将小数转换成对于的二进制形式
 *
 * @param len
 *            转换的长度。
 * @param data
 *            带转换的小数。
 * @return返回一个字符串，该字符串就是小数对应的字符串形式。
 */
        private static String toBin(int len, float data) {
        StringBuilder sb = new StringBuilder();
        float temp = data * 2;
        while (len> 0) {
        if (new Float(temp).intValue() >= 1) {
        sb.append("1");
        temp -= 1;
        } else {
        sb.append("0");
        }
        len--;
        temp *= 2;
        }
        return sb.toString();
        }
        private static float sum(List<Float>li, int index) {
        float temp = 0f;
        for (int j = 0; j<index; j++) {
        temp += li.get(j);
        }
        return temp;
        }
        }