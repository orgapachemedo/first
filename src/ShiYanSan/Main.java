package ShiYanSan;

/**
 * @auther Medo
 * @Time 2020 - 10 - 22 - 10:27
 */
public class Main {
    public static void main(String[] args) {
        Work work = new Work();
        Thread zhang = new Thread(work);
        Thread wang = new Thread(work);
        zhang.setName("zhangWorker");
        wang.setName("wangWorker");
        zhang.start();
        wang.start();
    }
}
