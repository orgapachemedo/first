package XinxilunSYY;

import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @auther Medo
 * @Time 2020 - 10 - 11 - 22:08
 */
public class testHuffTree {
    HuffCodeTree tree = new HuffCodeTree();

    public static void main(String[] args){
        testHuffTree huffcode = new testHuffTree();
        long start = System.currentTimeMillis();
        String encode = huffcode.encode(args[0]);
        System.out.println("解码：" + huffcode.decode(encode));
    }

    public String encode(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> charsInfoMap = countCharFrequence(chars);
        PriorityQueue<Nodee> nodeQue = arrangeByFre(charsInfoMap);
        buildHuffCodeTree(nodeQue);
        return this.tree.encode(chars);
    }

    public String decode(String str){
        return this.tree.decode(str);
    }
    public Map<Character, Integer> countCharFrequence(char[] chars) {
        Map<Character, Integer> charsInfoMap = new Hashtable<Character, Integer>();
        for (char c : chars) {
            Character cs = new Character(c);
            if (charsInfoMap.containsKey(cs)) {
                charsInfoMap.put(cs, charsInfoMap.get(cs) + 1);
            } else {
                charsInfoMap.put(cs, new Integer(1));
            }
        }
        return  charsInfoMap;
    }

    public PriorityQueue<Nodee> arrangeByFre(Map<Character, Integer> charsInfoMap){
        //通过优先队列 有序存放节点   当然节点必须重写compareTo方法
        PriorityQueue<Nodee> nodeQue= new PriorityQueue<>(charsInfoMap.size());
        for (Character key : charsInfoMap.keySet()) {
            Nodee node = new Nodee(key.toString(), charsInfoMap.get(key));
            nodeQue.add(node);
            this.tree.addleaf(node);
        }
        return nodeQue;
    }
    public void buildHuffCodeTree(PriorityQueue<Nodee> nodeQue){
        if(nodeQue == null || nodeQue.size() == 0){
            return;
        }

        //构造哈夫曼树 小的节点为左子树 大的节点为右
        while(nodeQue.size() > 1){
            Nodee node1 = nodeQue.poll();
            Nodee node2 = nodeQue.poll();
            Nodee parent = new Nodee(node1.chars + node2.chars,
                    node1.frequence + node2.frequence);
            parent.leftChild = node1;
            parent.rightChild = node2;

            node1.parentChild = parent;
            node2.parentChild = parent;

            nodeQue.add(parent);
        }
        this.tree.root = nodeQue.poll();
    }
}
