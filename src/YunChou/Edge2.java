package YunChou;

/**
 * @author lwm
 * @create 2020-11-13-15:58
 */
public class Edge2 {
    private int v1;
    private int v2;
    private int flow;

    public Edge2(int v1,int v2,int flow){
        this.v1 = v1;
        this.v2 = v2;
        this.flow = flow;
    }

    public int getV1(){
        return v1;
    }

    public int getV2(){
        return v2;
    }

    public int getFlow(){
        return flow;
    }

    public void setFlow(int f){
        flow = f;
    }

}
