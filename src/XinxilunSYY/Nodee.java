package XinxilunSYY;

/**
 * @auther Medo
 * @Time 2020 - 10 - 11 - 20:37
 */
public class Nodee<T> implements Comparable<Nodee> {
    public String chars = "";
    public int frequence;
    public Nodee leftChild;
    public Nodee rightChild;
    public Nodee parentChild;

    public Nodee(String str, int fre){
        this.chars = str;
        this.frequence = fre;
    }

    public void displayNode(){
        System.out.println("节点： " + chars + " " + frequence);
    }
    public boolean isLeftChild(){
        return this.parentChild != null && this.parentChild.leftChild == this;
    }

    @Override
    public int compareTo(Nodee o) {
        return this.frequence - o.frequence;
    }
}