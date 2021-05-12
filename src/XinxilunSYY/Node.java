package XinxilunSYY;

/**
 * @auther Medo
 * @Time 2020 - 10 - 06 - 20:53
 */
public  class  Node implements Comparable{
    public int value;
    public char name;
    public Node left;
    public Node parent;
    public Node right;
    public Node(int value) {

        this.value = value;
    }
    @Override
    public String toString() {
        return "Node [value=" + value + ", left=" + left + ", right="
                + right + "]";
    }

    public Node(char name) {
        this.name = name;
    }

    public Node() {
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this.value);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Object o) {
        Node node = (Node) o;
        return this.value - node.value;
    }
}
