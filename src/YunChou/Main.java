package YunChou;
/**
 * @author lwm
 * @create 2020-11-13-15:55
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        Edge[] edges = new Edge[9];
        edges[0] = new Edge(0,1,1,5);
        edges[1] = new Edge(0,2,3,3);
        edges[2] = new Edge(1,3,2,2);
        edges[3] = new Edge(2,1,1,1);
        edges[4] = new Edge(2,4,3,4);
        edges[5] = new Edge(3,2,1,1);
        edges[6] = new Edge(3,4,0,3);
        edges[7] = new Edge(3,5,1,2);
        edges[8] = new Edge(4,5,3,5);
        for(int i = 0;i<9;i++)
            graph.insertEdge(edges[i]);
        graph.MaxFlow();
        graph.showResult();
    }


}
