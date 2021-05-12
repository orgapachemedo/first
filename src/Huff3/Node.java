package Huff3;

/**
 * @auther Medo
 * @Time 2020 - 10 - 11 - 23:09
 */
public class Node {
    private String ch;
    private int num;
    private Node left;
    private Node right;
    public Node(String c, int n){
        ch = c;
        num = n;
    }
    public Node(){
    }
    public String getCh() {
        return ch;
    }
    public void setCh(String ch) {
        this.ch = ch;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "Node{" +
                "ch='" + ch + '\'' +
                ", num=" + num +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

