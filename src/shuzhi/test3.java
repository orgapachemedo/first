package shuzhi;

public class test3 {
    public static void main(String[] args) {
        double x1=0, x2=0, x3=0;                //初始值
        double x1_i, x2_i, x3_i;                //迭代后的值
        int i=0;
        double error=1.0;                       //误差
        double Precision = Math.pow(10,-4);     //精度
        double max;                             //两次迭代相减后的行范数
        double[] vector = new double[3];                          //两次迭代相减后的向量
        do {
            i++;
//          迭代计算x
            x1_i = (-0.4*x2)-(0.2*x3)-2.4;
            x2_i = (0.25*x1)-(0.5*x3)+5;
            x3_i = (-0.2*x1)+(0.3*x2)+0.3;

//            将x_k+1和x_k进行相减
            vector[0]= Math.abs(x1_i-x1);
            vector[1]= Math.abs(x2_i-x2);
            vector[2]= Math.abs(x3_i-x3);
//            得到行范数
            max = Math.abs(vector[0]);
            for (int j=0; j<vector.length;j++){
                if (max<Math.abs(vector[j])){
                    max = Math.abs(vector[j]);
                }
            }
            error = max;
//            更新x的值
            x1 = x1_i;
            x2 = x2_i;
            x3 = x3_i;
            System.out.print("第"+i+"次迭代：");
            if (error>Precision){
                System.out.printf("x1=%-4f     x2=%-4f     x3=%-4f     ",x1, x2, x3);
            }else {
                System.out.printf("x1=%-4f     x2=%-4f     x3=%-4f     ",x1, x2, x3);
            }
            System.out.println();
        }while (error>Precision);
//        得到最终结果
        System.out.println("符合精度的值为:");
        System.out.println("x1="+x1+";  x2="+x2+";    x3="+x3);
    }
}
