package YunChou;

/**
 * @author lwm
 * @create 2020-11-06-10:18
 */
public class SYY {
    public static void main(String[] args) {
        GraphTree graphTree = new GraphTree();
        showGraph(graphTree);
        StringBuffer stringBuffer = decide(graphTree,3);
        System.out.println(stringBuffer);
    }

    private static StringBuffer decide(GraphTree graphTree,int min) {
        int loc = 0 ;
        int sum = min;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A");
        for (int i = 0; i <16 ; i = loc ) {
            for (int j = 0 ; j <16;j++){
                if (graphTree.EdgeWeight[i][j] != 99){
                     loc = finfMin(graphTree,i,j);//返回此节点的位置
                    stringBuffer.append(graphTree.Vertex[loc]);//保存路径
                    break;
                }
            }
            if (i >= 10){
                break;
            }
        }
        stringBuffer.append("G");
        return stringBuffer;
    }

    private static int finfMin(GraphTree graphTree,int i,int j) {
        int loc = 0 ;
        if (i == 2 || i == 1) {
            loc = array(graphTree, i, j);

        } else if (i < 10){
            loc = arrayTwo(graphTree, i, j);
        }else if (i >= 10){
            if (i == 10){
                loc = 13;
            }else{
                loc = 14;
            }
        }

        return loc;
    }

    private static int arrayTwo(GraphTree graphTree, int i, int j) {
        //判断节点中只有两条路径的最小权值
        int locm = 0;
        int locM = 0;
        if (graphTree.EdgeWeight[i][j] == graphTree.EdgeWeight[i][j + 1]) {
            for (int k = 0; k < 16; k++) {
                if (graphTree.EdgeWeight[j][k] != 99) {
                    locm = minTwo(graphTree, j , k);
                }
                if (graphTree.EdgeWeight[j+1][k] != 99) {
                    locM = minTwo(graphTree, j+1 , k);
                }
//                if (k == 13){
//                    break;
//                }
            }
            return locm>locM?j+1 : j;
        }
        else {
            if (graphTree.EdgeWeight[i][j] > graphTree.EdgeWeight[i][j + 1]) {
                    return j + 1;
            }else{
                return j;
            }

        }
    }

    private static int minTwo(GraphTree graphTree, int j, int k) {
        //判断节点中最小值
        int min = Math.min(graphTree.EdgeWeight[j][k],graphTree.EdgeWeight[j][k+1]);

        return min;
    }

    private static int array(GraphTree graphTree, int i, int j) {
        //求节点有3条路径的最小值
        int loc = 0 ;
        int min=graphTree.EdgeWeight[0][0];
        for(int k = j ;k <= j +2;k++)
        {
            if(min>graphTree.EdgeWeight[i][k])
            {
                min=graphTree.EdgeWeight[i][k];
                loc = k;
            }
        }
        return loc;
    }


    private static void showGraph(GraphTree graphTree) {
        for(int i=0;i<graphTree.VertexNum;i++){
            System.out.print("\t"+graphTree.Vertex[i]); //第一行输出顶点信息
        }
        System.out.println();
        for(int i=0;i<graphTree.VertexNum;i++){
            System.out.print(" "+graphTree.Vertex[i]);
            for(int j=0;j<graphTree.VertexNum;j++){
//                if(graphTree.EdgeWeight[i][j]==graphTree.MAX){
//                    System.out.print("Z");
//                }else{
                    System.out.print("\t"+graphTree.EdgeWeight[i][j]);
//                }
            }
            System.out.println();
        }
    }

}
class  GraphTree{
        public static int MAX = 99;
        public static int  VertexNum = 16;//顶点数量
        public static int  EdgeNum = 30;   //边的数量
        public static String[] Vertex=new String[]{
                "A","B1","B2",
                "C1","C2","C3","C4",
                "D1","D2","D3","E1",
                "E2","E3","F1","F2","G"
    }; //保存顶点信息
        public static int[][] EdgeWeight=new int[][]{
                //    A  B1 B2 C1 C2 C3 C4 D1 D2 D3 E1 E2 E3 F1 F2 G
                new int[]{99, 5, 3,99,99,99,99,99,99,99,99,99,99,99,99,99},
                new int[]{99,99,99, 1, 3, 6,99,99,99,99,99,99,99,99,99,99},
                new int[]{99,99,99,99, 8, 7, 6,99,99,99,99,99,99,99,99,99},
                new int[]{99,99,99,99,99,99,99, 6, 8,99,99,99,99,99,99,99},
                new int[]{99,99,99,99,99,99,99, 3, 5,99,99,99,99,99,99,99},
                new int[]{99,99,99,99,99,99,99,99, 3, 3,99,99,99,99,99,99},
                new int[]{99,99,99,99,99,99,99,99, 8, 4,99,99,99,99,99,99},
                new int[]{99,99,99,99,99,99,99,99,99,99, 2, 2,99,99,99,99},
                new int[]{99,99,99,99,99,99,99,99,99,99,99, 1, 2,99,99,99},
                new int[]{99,99,99,99,99,99,99,99,99,99,99, 3, 3,99,99,99},
                new int[]{99,99,99,99,99,99,99,99,99,99,99,99,99, 3, 5,99},
                new int[]{99,99,99,99,99,99,99,99,99,99,99,99,99, 5, 2,99},
                new int[]{99,99,99,99,99,99,99,99,99,99,99,99,99, 6, 6,99},
                new int[]{99,99,99,99,99,99,99,99,99,99,99,99,99,99,99, 4},
                new int[]{99,99,99,99,99,99,99,99,99,99,99,99,99,99,99, 3},
                new int[]{99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99}
    };//保存权
}
