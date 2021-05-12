package OpreatorSystem.experiment_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @auther lwm
 * @create 2021-05-11-19:29
 */
public class dao {
    private Scanner scanner ;
    private myStorer[] myStorers ;

    public dao(){
        scanner = new Scanner(System.in);
        myStorers = new myStorer[]{
                new myStorer(100,50,"已用"),
                new myStorer(150,10,"未用"),
                new myStorer(160,5,"已用"),
                new myStorer(165,15,"已用"),
                new myStorer(180,25,"未用"),
                new myStorer(205,15,"未用")
        };

    }

    public void  show(ArrayList<myStorer> myStorers){
        Iterator<myStorer> iterator = myStorers.iterator();

        System.out.println("地址 状态 容量");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public ArrayList<myStorer> init(){
        ArrayList<myStorer> myStorer = new ArrayList<>();
        for (int i = 0; i < this.myStorers.length; i++) {
            myStorer.add(myStorers[i]);
        }
        System.out.println();
        return myStorer;
    }

    public void run(){
        ArrayList<myStorer> storers = init();
        ArrayList<Integer> integers = new ArrayList<>();
        int k = 0;
        int sum = 0 ;
        show(storers);
        System.out.println("请输入所需要的储存空间:)");
        String input = scanner.nextLine();
        String[] s = input.split(" ");
        for (String s1 : s) {
            integers.add(Integer.valueOf(s1));
            k++;
        }
        for (int i = 0; i < integers.size(); i++) {
            sum  += integers.get(i);

        }
        if (sum > 60 || sum <= 0){
            System.out.println("请求储存过大 请重新运行此程序");
            System.exit(1);
        }
        show(first(storers,integers));
        showArr(worest(myStorers,integers));
//        worest(storers,integers);


    }
    public void showArr(myStorer[] s){
        System.out.println("地址 状态 容量");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    //最先适配法
    public ArrayList<myStorer> first(ArrayList<myStorer> myStoes,ArrayList<Integer> request){
        System.out.println("最先适配法：");
        ArrayList<myStorer> newStore = new ArrayList<>();
        int job = 0;
        int store;
        int j = 0;
        myStorer Storer = new myStorer();
        for (int i = 0; i < request.size(); i++) {
            if (i != 0 && j == 0){
                System.out.println("没有合适的空间分配作业");
                break;
            }
            for (int k = 0; k < myStoes.size(); k++) {
                if (i == 0 ){
                    Storer = myStoes.get(k);
                    store = Storer.getSize();
                    job = request.get(i);
                    if (job > store || Storer.getState().equals("已用")){
                        newStore.add(Storer);
                        continue;
                    }else {
                        newStore.add(Storer);
                        Storer.setSize(job);
                        Storer.setState("已用");
                        myStorer s = new myStorer(Storer.getAddress()  + job,store - job,"未用");
                        newStore.add(s);
                        j = k ;
                        break;
                    }
                }else {
                    if (k == 0 ){
                    k = j + 1  ;
                    }
                    Storer = myStoes.get(k);
                    store = Storer.getSize();
                    job = request.get(i);
                    if (job > store || Storer.getState().equals("已用")){
                        newStore.add(Storer);
                        continue;
                    }else {
                        newStore.add(Storer);
                        Storer.setSize(job);
                        Storer.setState("已用");
                        myStorer s = new myStorer(Storer.getAddress() + Storer.getSize(),store - job,"未用");
                        newStore.add(s);
                        j = k ;
                        break;
                    }
                }

            }
        }
        for (int k = j + 1; k < myStoes.size(); k++) {
            newStore.add(myStoes.get(k));
        }
        return newStore;
    }
    //最优适配法
    public ArrayList<myStorer> best(ArrayList<myStorer> myStoes,ArrayList<Integer> request){
        System.out.println("最优适配法");
        ArrayList<myStorer> newS = new ArrayList<>();

        return newS;
    }
    //最坏适配法
    public myStorer[] worest(myStorer[] myStoes,ArrayList<Integer> request){
        System.out.println("最坏适配法");
        int max = findMax(myStoes); ;
        int index = -1 ;
        myStorer[] newS =null ;
        for (int i = 0; i < request.size(); i++) {
            if (newS == null ) {
                index = findMaxIndex(myStoes, max);
                max = findMax(myStoes);
            }else {
                max = findMax(newS);
                index = findMaxIndex(newS, max);
            }
            if (request.get(i) > max || index == -1 ){
                    System.out.println("作业需求内存过大 ");
                    System.exit(1);
            }
            else{
                    int jobsize = request.get(i);
                    if (newS == null ) {
                        newS = changePosition(myStoes, index, max, jobsize);
                    }
                    else {
                        newS = changePosition(newS,index,max,jobsize);
                    }
                }
            }

        return newS;
    }
    //坏 插入位置
    public myStorer[] changePosition(myStorer[] s,int ind,int size,int jobsize){
        s[ind].setState("已用");
        s[ind].setSize(jobsize);
        if ( size == jobsize){
            return s;
        }else {
            myStorer mytorer = new myStorer(s[ind].getAddress() + jobsize, size - jobsize, "未用");
            int j = 0;
            myStorer[] newS = new myStorer[s.length + 1];
            for (int i = 0; i < s.length; i++) {
                newS[i] = s[i];
            }
            for (int i = 0; i < s.length; i++) {
                if (s[i] == null) {
                    j = i;
                    break;
                }
            }
            for (int i = newS.length - 1; i >= ind; i--) {
                if (ind == newS.length - 2) {
                    newS[i] = mytorer;
                    break;
                } else {
                    if (i != ind) {
                        newS[i] = newS[i - 1];
                    } else {
                        newS[i + 1] = mytorer;
                    }
                }
            }
            return newS;
        }
    }
    //坏 找最大值所在位置
    public int findMaxIndex(myStorer[] s,int max){
        int index = -1 ;
        for (int i = 0; i < s.length; i++) {
            if (max == s[i].getSize()){
                index = i;
            }
        }
        return index;
    }
    //坏 找最大值
    public int findMax(myStorer[] s){
        int max = 0 ;
        for (int i = 0; i < s.length; i++) {
            if (s[i].getState().equals("未用")){
            max = Math.max(s[i].getSize() , max);
        }
        }
        return max ;
    }


}
