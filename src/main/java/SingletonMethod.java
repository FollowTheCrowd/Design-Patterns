/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 02:18
 */
 class Singleton{
    //私有静态成员变量，用来保存单例实例
    private static Singleton instance;

    private Singleton(){
        //初始化操作
    }

    //计数器，用来验证我们的线程不冲突
    private int count = 0;

    //公共静态方法，用于获取单例实例
    //注意这里使用双重校验锁防止线程冲突
    public static Singleton getInstance(){
        if(instance == null){ // 第一次检查
            synchronized (Singleton.class){ //加锁
                if(instance == null){ //第二次检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 给 count +1（必须加 synchronized，否则线程不安全）
    public synchronized void add() {
        count++;
    }
    public int getCount() {
        return count;
    }



}

public class SingletonMethod {
     public static void main(String[] args) throws InterruptedException {
         int threadCount = 1000;
         Thread[] threads = new Thread[threadCount];
         //for循环创建1000个线程来进行加法
         for(int i=0;i<threadCount;i++){
             threads[i] = new Thread(() -> {
                 Singleton singleton = Singleton.getInstance();
                 singleton.add();
             });
             threads[i].start();
         }
         //等待所有线程执行完成
         for(Thread thread : threads){
             thread.join();
         }

         // 最终结果一定是 1000
         System.out.println("最终计数：" + Singleton.getInstance().getCount());


     }
}
