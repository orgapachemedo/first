package OpreatorSystem.experiment_1;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @auther lwm
 * @create 2021-05-11-14:15
 */
public class dao {
    private Scanner scanner ;
    private myProcess[] pro;

    public dao() {
        scanner = new Scanner(System.in);
        myProcess process1 = new myProcess(1, 0, 20, 100, 20, "就绪");
        myProcess process2 = new myProcess(2, 0, 20, 99, 20, "就绪");
        myProcess process3 = new myProcess(3, 0, 20, 98, 20, "就绪");
        myProcess process4 = new myProcess(4, 0, 20, 97, 20, "就绪");
        myProcess process5 = new myProcess(5, 0, 20, 96, 20, "就绪");
        pro = new myProcess[]{process1,process2,process3,process4,process5};
    }
    //初始化队列
    public ArrayList<myProcess> init(myProcess[] myProcesses){
        ArrayList<myProcess> process = new ArrayList<>();
        for (int i = 0; i < myProcesses.length; i++) {
            process.add(myProcesses[i]);
        }
        sortMyarray(process);
        return process;
    }
    //展示队列
    public void showqueue(ArrayList<myProcess> proes){
        System.out.println("当前队列：");
        Iterator<myProcess> iterator = proes.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //判断输入的参数是否正确
    public boolean isrightRunTime(int i , ArrayList<myProcess> proes ){
        boolean right = false;
        myProcess myProcess1 = proes.get(0);
        if (i > 0 && i <= myProcess1.getLasttime()){
            right = true;
        }
        return right;
    }

    //给进程排序
    public void sortMyarray(ArrayList<myProcess> proes){
        proes.sort(new Comparator<myProcess>() {
            @Override
            public int compare(myProcess o1, myProcess o2) {
                int i = 0;
                if (o1.getPrority() > o2.getPrority()){
                    i = -1;
                }else {
                    i = 1;
                }
                return i;
            }
        });

    }

    public void drop(ArrayList<myProcess> proes){
        proes.remove(0);
    }

    public int runtimeInput(ArrayList<myProcess> proes){
        int runtime = 0 ;
        System.out.println("输入当前进程所需运行时间：");
        while (true) {
            runtime = scanner.nextInt();
            if (runtime == 0  ) {
                proes.get(0).setState("结束");
                showqueue(proes);
                System.out.println();
                System.out.println("process[" + proes.get(0).getId() + "] 退出队列");
                System.out.println();
                drop(proes);
                break;
            } else if (!isrightRunTime(runtime, proes)) {
                System.out.println("输入运行时间错误 请重新输入");
            } else {
                break;
            }
        }
        return  runtime;
    }

    public void currentProcess(myProcess process,int runtime){
        process.setState("运行");
        System.out.println();
        System.out.println(process + ":  正在运行中....");
        System.out.println();
        try {
            Thread.sleep(runtime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        process.setState("就绪");
    }

    public void run(){
        ArrayList<myProcess> proes = init(pro);
        int runtime ;
        int pro ;
        int lasttime;
        int rt  ;
        int iszero ;
        myProcess myProcess = new myProcess();
        while (proes.size() >=1 ) {
            showqueue(proes);
            runtime = runtimeInput(proes);
            if (runtime == 0 ){
                continue;
            }
            myProcess = proes.get(0);
            currentProcess(myProcess,runtime);
            rt = myProcess.getRuntime();
            pro = myProcess.getPrority();
            myProcess.setLasttime(myProcess.getLasttime() - runtime);
            lasttime = myProcess.getLasttime();
            myProcess.setRuntime(runtime + rt);
            if (lasttime <= 0){
                    proes.get(0).setState("结束");
                    showqueue(proes);
                    System.out.println();
                    System.out.println("process[" + myProcess.getId() + "] 退出队列");
                    System.out.println();
                    drop(proes);
                    continue;
                }

            myProcess.setPrority(pro - 5);
            sortMyarray(proes);
        }
        System.out.println("所有进程运行完毕");
    }
}
