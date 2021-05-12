package ShiYanSan;

import java.util.TreeMap;

/**
 * @auther Medo
 * @Time 2020 - 10 - 22 - 10:19
 */
public class Work implements Runnable {
    private  static int i  = 1 ;
    private  static int k  = 1 ;
    @Override
    public void run() {
        for (int j = 1; j <= 20; j++) {
            synchronized (this){

                if ( Thread.currentThread().getName().equals("zhangWorker") ) {
                    this.notify();
                    if (i == k && i != 1 && j != 1){
                        System.out.println("老板让他们继续工作");
                    }
                    System.out.println(Thread.currentThread().getName() + "搬运第" + i + "箱苹果");
                    i++;

                    try {
                        this.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }if ( Thread.currentThread().getName().equals("wangWorker") ){
                    this.notify();
                    if (i == k && i != 1 && j != 1){
                        System.out.println("老板让他们继续工作");
                    }
                    System.out.println(Thread.currentThread().getName() + "搬运第" + k + "箱香蕉");
                    k++;
                    try {
                        this.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
