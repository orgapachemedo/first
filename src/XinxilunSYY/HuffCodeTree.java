package XinxilunSYY;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @auther Medo
 * @Time 2020 - 10 - 11 - 22:06
 */
public class HuffCodeTree {
    Nodee root = null;
    /**
     * 所有叶子节点 即所有进行编码的字符所在的节点
     * */
    public List<Nodee> leaves = new LinkedList<>();

    public String encode(char[] chars){
        if(chars.equals("")){return "";}

        // 对所有出现的字符进行编码
        Map<Character, String> chara_encoding = new HashMap<>();
        for(Nodee leaf : this.leaves){
            Nodee node = leaf;
            String charcode = "";
            while(node != root) {
                if (node.isLeftChild()) {
                    charcode = '0' + charcode;
                } else {
                    charcode = '1' + charcode;
                }
                node = node.parentChild;
            }
//            System.out.print(leaf.chars+ " : " + charcode + "  ");
            chara_encoding.put(leaf.chars.charAt(0), charcode);
        }

        StringBuffer code = new StringBuffer();
        for(char c : chars){
            code.append(chara_encoding.get(c));
        }
        return code.toString();
    }

    public void addleaf(Nodee e){
        Nodee node = e;
        this.leaves.add(node);
    }

    public void preOrderTra(){
        preOrderTra(root);
    }

    //递归 先序遍历
    public void preOrderTra(Nodee localRoot) {
        if(localRoot != null) {
            localRoot.displayNode();
            preOrderTra(localRoot.leftChild);
            preOrderTra(localRoot.rightChild);
        }
    }

    public String decode(String str){
        if(root == null){
            return null;
        }
        String deocodeString = "";
        Nodee node = root;
        for(char c : str.toCharArray()){
            if(node.leftChild == null && node.rightChild == null){
                deocodeString += node.chars;
                node = root;
            }
            if(c == '0'){
                node = node.leftChild;
            }else if(c == '1') {
                node = node.rightChild;
            }
        }
        return deocodeString;
    }
}

