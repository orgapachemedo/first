package OpreatorSystem.experiment_2;

/**
 * @auther lwm
 * @create 2021-05-11-19:22
 */
public class myStorer {
    private int address;
    private int size;
    private String state;

    @Override
    public String toString() {
        return
                 address + "\t" +
                 state + '\t' +
                 size;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public myStorer() {
    }

    public myStorer(int address, int size, String state) {
        this.address = address;
        this.size = size;
        this.state = state;
    }
}
