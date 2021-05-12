package Huff3;

import XinxilunSYY.testHuffTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @auther lwm
 * @Time 2020 - 10 - 11 - 23:09
 */
public class Hafuman {
    public static void main(String[] args) {
        String str = "TianJinligongdaxueJisuanjixueYuan";
        String[]  ar = new String[]{str};
        System.out.println("原码：" + str);
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String ch = str.charAt(i) + "";
            if(map.get(ch) == null) {
                map.put(ch,1);
            }
            else{
                map.put(ch,map.get(ch)+1);
            }
        }
        ArrayList<Node> arr = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            Node no = new Node(stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
            arr.add(no);
        }
        for (;;){
            if (arr.size() > 1){
                Node[] data= getNode(arr);
                Node root = new Node(null, data[0].getNum()+data[1].getNum());
                root.setLeft(data[0]);
                root.setRight(data[1]);
                arr.add(root);
            }else{
                break;
            }
        }
        Node tree = arr.get(0);
        Map<String,String> charMaps = new HashMap<>();
        Map<String, String> codeMaps = new HashMap<>();
        allView(tree,"",charMaps,codeMaps);
        String hafucode = "";
        for (int i = 0; i < str.length(); i++) {
            String ch = str.charAt(i) + "";
            hafucode += charMaps.get(ch);
        }
        System.out.println(hafucode);
        System.out.println("解码：" + decode(str));
    }
    private static String decode(String s) {
        return s;
    }
    public static void allView(Node tree, String code, Map<String,String> charMaps,Map<String,String> codeMaps){
        if (tree.getLeft() == null){
            System.out.println(tree.getCh() + "出现次数" + tree.getNum() + "--code:" + code);
            charMaps.put(tree.getCh(),code);
            codeMaps.put(code,tree.getCh());
        }else{
            allView(tree.getLeft(),code + "0",charMaps,codeMaps);
            allView(tree.getRight(), code + "1", charMaps, codeMaps);
        }
    }
    public static Node[] getNode(ArrayList<Node> arr) {
        Node[] nos = new Node[2];
        int min1;
        int min2;
        if (arr.get(0).getNum() <= arr.get(1).getNum()) {
            min1 = 0;
            min2 = 1;
        } else {
            min1 = 1;
            min2 = 0;
        }
        for (int i = 2; i < arr.size(); i++) {
            if (arr.get(i).getNum() < arr.get(min1).getNum()) {
                min2 = min1;
                min1 = i;
            } else if (arr.get(i).getNum() >= arr.get(min1).getNum() && arr.get(i).getNum() < arr.get(min2).getNum()) {
                min2 = i;
            }
        }
        nos[0] = arr.get(min1);
        nos[1] = arr.get(min2);
        arr.remove(min1);
        if (min2 > min1) {
            arr.remove(min2 - 1);
        } else {
            arr.remove(min2);
        }
        return nos;
    }
}


