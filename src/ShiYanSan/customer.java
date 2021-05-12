package ShiYanSan;

/**
 * @auther Medo
 * @Time 2020 - 10 - 22 - 11:00
 */
class Movie extends Thread {
        private static int  fivenumber=1,tennumber=0,twentynumber=0;
        private int count = 0,money=0;
        public synchronized void chan(int money,int count) {
            if (money == 20 && count == 2) {
                twentynumber++;
                if(tennumber<1)
                {
                    try {
                        System.out.println("赵稍等"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber);
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                while(tennumber<1) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                tennumber--;
                notify();
                System.out.println("应该找给赵1张10元，赵结束"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber);//好了这个人结束了

            }
            //money == 20 && count == 1
            else if (money == 20 && count == 1) {
                twentynumber++;
                if(tennumber<1||fivenumber<1)
                {try {
                    System.out.println("钱稍等"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber);
                    this.wait();
                } catch (InterruptedException e) {}
                }
                while(tennumber<1||fivenumber<1) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                tennumber--;
                fivenumber--;
                notify();
                System.out.println("应该找给钱1张10元、1张5元，钱结束"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber
                );
            }

            else if (money == 10 && count == 1) {
                tennumber++;
                if(fivenumber<1)
                {
                    try {

                        System.out.println("孙稍等"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber);
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                while(fivenumber<1) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                fivenumber--;
                notify();
                System.out.println("应该找给孙1张5元，孙结束"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber);
            }
            else if (money == 10 && count == 2) {
                tennumber++;
                System.out.println("李结束"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber);
                notify();
            }
            else if (money == 5 && count == 1) {
                fivenumber++;
                System.out.println("周结束"+"   此时售票员手中的票为:5元有"+fivenumber+",10元有："+tennumber+"，20元有："+twentynumber);
                notify();
            }
        }
    }


    public  class customer extends Thread
    {
        String name;
        static Movie buy=new Movie();
        public customer(String name) {
            this.name=name;
        }
        public void run() {
            synchronized(this.buy) {
                if(name=="赵") buy.chan(20,2);
                else if(name=="钱") buy.chan(20,1);
                else if(name=="孙") buy.chan(10,1);
                else if(name=="李") buy.chan(10, 2);
                else if(name=="周") buy.chan(5,1);//调用上了互斥锁的方法来找钱
            }
        }
        public static void main(String[] args) {
            new customer("赵").start();
            new customer("钱").start();
            new customer("孙").start();
            new customer("李").start();
            new customer("周").start();
        }
    }


