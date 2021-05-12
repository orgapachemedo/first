package OpreatorSystem.experiment_1;

/**
 * @auther lwm
 * @create 2021-05-11-14:04
 */
public class myProcess {
    private int id ;
    private int runtime ;
    private int lasttime ;
    private int prority;
    private int totaltime;
    private String state;
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "myProcess[" +
                 id  + "]" +
                " = {id=" + id +
                ", 运行时间=" + runtime +
                ", 剩余运行时间=" + lasttime +
                ", 优先级=" + prority +
                ", 总时间=" + totaltime +
                ", 状态='" + state + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getLasttime() {
        return lasttime;
    }

    public void setLasttime(int lasttime) {
        this.lasttime = lasttime;
    }

    public int getPrority() {
        return prority;
    }

    public void setPrority(int prority) {
        this.prority = prority;
    }

    public int getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(int totaltime) {
        this.totaltime = totaltime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public myProcess() {
    }

    public myProcess(int id, int runtime, int lasttime, int prority, int totaltime, String state) {
        this.id = id;
        this.runtime = runtime;
        this.lasttime = lasttime;
        this.prority = prority;
        this.totaltime = totaltime;
        this.state = state;
    }
}
