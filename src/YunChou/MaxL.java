package YunChou;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author lwm
 * @create 2020-11-13-12:34
 */
public class MaxL {
    public static int maxV = Integer.MAX_VALUE;
    public static int[][] capacity = new int[6][6]; //用于统计给定图前向边和后向边剩余流量
    public static int[] flow = new int[6];  //用于统计从源点到图中任意一点i的最大可增加的流量
    public static int[] pre = new int[6];  //用于记录当前到达顶点的前驱顶点
    public int bfs(int[][] graph) {  //使用BFS遍历，寻找给定图的增广路径
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);      //源点为顶点0
        for(int i = 0;i < 6;i++) {
            pre[i] = -1;   //初始化所有顶点的前驱顶点为-1
        }
        pre[0] = 0;     //源点的前驱顶点设定为自己
        flow[0] = maxV; //源点的前驱顶点到源点的增加流量设定为无穷大
        while(!list.isEmpty()) {
            int index = list.get(0);
            list.remove(0);
            if(index == 5)
                break;
            for(int i = 0;i < graph.length;i++) {
                if(capacity[index][i] > 0 && pre[i] == -1) {//当顶点i未被访问且到达顶点i有剩余流量时
                    pre[i] = index;  //顶点i的前驱顶点为index
                    flow[i] = Math.min(flow[index], capacity[index][i]);
                    list.add(i);
                }
            }
        }
        if(pre[5] != -1)
            return flow[5];
        return -1;
    }

    public void getResult(int[][] graph) {
        int result = 0;
        int temp = bfs(graph);
        while(temp != -1) {
            result = result + temp;
            int start = pre[5];
            int end = 5;
            while(start != 0) {
                capacity[start][end] -= temp;   //前向边剩余流量减少temp
                capacity[end][start] += temp;   //后向边剩余流量增加temp
                end = start;
                start = pre[end];
            }
            capacity[0][end] -= temp;
            capacity[end][0] += temp;
            temp = bfs(graph);
        }
        System.out.println("给定图的最大流量为："+result);
        return;
    }

    public static void main(String[] args) {
        MaxL test = new MaxL();
        int[][] graph = new int[6][6];
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();   // 给定图的边数目
        for(int i = 0;i < num;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int value = in.nextInt();
            graph[a - 1][b - 1] = value;
            capacity[a - 1][b - 1] = value;//前向边起始剩余流量为边的容量，后向边起始剩余流量为0
        }
        test.getResult(graph);
    }
}
