package YunChou;

/**
 * @author lwm
 * @create 2020-11-12-13:09
 */
public class DK {
    public int[] getShortestPaths(int[][] adjMatrix) {
        int[] result = new int[adjMatrix.length];   //用于存放顶点v1到其它顶点的最短距离
        boolean[] used = new boolean[adjMatrix.length];  //用于判断顶点是否被遍历
        used[0] = true;  //表示顶点0已被遍历
        for(int i = 1;i < adjMatrix.length;i++) {
            result[i] = adjMatrix[0][i];
            used[i] = false;
        }

        for(int i = 1;i < adjMatrix.length;i++) {
            int min = Integer.MAX_VALUE;    //用于暂时存放顶点v1到vi的最短距离，初始化为Integer型最大值
            int k = 0;
            for(int j = 1;j < adjMatrix.length;j++) {  //找到顶点v1到其它顶点中距离最小的一个顶点
                if(!used[j] && result[j] != -1 && min > result[j]) {
                    min = result[j];
                    k = j;
                }
            }
            used[k] = true;    //将距离最小的顶点，记为已遍历
            for(int j = 1;j < adjMatrix.length;j++) {  //然后，将顶点v1到其它顶点的距离与加入中间顶点vk之后的距离进行比较，更新最短距离
                if(!used[j]) {  //当顶点vj未被遍历时
                    //首先，顶点vk到顶点vj要能通行；这时，当顶点v1到顶点vj的距离大于顶点v1到vk再到vj的距离或者顶点v1无法直接到达顶点vj时，更新顶点v1到顶点vj的最短距离
                    if(adjMatrix[k][j] != -1 && (result[j] > min + adjMatrix[k][j] || result[j] == -1))
                        result[j] = min + adjMatrix[k][j];
                    
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] vexs = {"v1","v2","v3","v4", "v5","v6","v7","v8","v9"};
        DK test = new DK();
        int[][] adjMatrix =
                {
                                 /*v1*//*v2*//*v3*//*v4*//*v5*//*v6*//*v7*//*v8*//*v9*/
                        /*v1*/ {     0,    6,    3,    1,  -1,  -1,  -1,  -1,   -1},
                        /*v2*/ {     6,    0,    2,  -1,    1,  -1,  -1,   -1,   -1},
                        /*v3*/ {     3,    2,    0,    2,  -1,  -1,  -1,   -1,   -1},
                        /*v4*/ {     1,  -1,    2,    0,    6,   10,  -1,  -1,  -1},
                        /*v5*/ {   -1,    1,  -1,    6,    0,    4,    3,     6,     2},
                        /*v6*/ {   -1,  -1,  -1,   10,    4,    0,    2,   -1,   -1},
                        /*v7*/ {   -1,  -1,  -1,  -1,    3,    2,    0,     4,   -1},
                        /*v8*/ {   -1,  -1,  -1,  -1,    6,  -1,    4,     0,     3},
                        /*v9*/ {   -1,  -1,  -1,  -1,    2,  -1,  -1,     3,     0}

                };
        int[] result = test.getShortestPaths(adjMatrix);
        System.out.println("顶点V1到图中所有顶点之间的最短距离为：");
        for(int i = 0;i < result.length;i++)
            System.out.print(vexs[i] + ":" + result[i]+" ");
    }
}
