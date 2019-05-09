package com.example.designpatterns.singletons;


/**
 * 双重检测锁
 * 解决懒汉式下的线程安全问题
 */
public class DoubleCheckSingleton {

    private DoubleCheckSingleton() {
    }
    //volatile 防止指令重排序 导致可能出现的线程安全问题
    private static volatile DoubleCheckSingleton doubleCheckSingleton = null;

    public static DoubleCheckSingleton getDoubleCheckSingleton() throws InterruptedException {
            if (doubleCheckSingleton == null) {
                synchronized (DoubleCheckSingleton.class) {
                   if (doubleCheckSingleton == null) {//第二次判断
                        doubleCheckSingleton = new DoubleCheckSingleton();
//                        TimeUnit.SECONDS.sleep(5);
                    }
                }
            }
        return doubleCheckSingleton;
    }


    public static void main(String[] args) throws InterruptedException {

        DoubleCheckSingleton doubleCheckSingleton = DoubleCheckSingleton.getDoubleCheckSingleton();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getDoubleCheckSingleton();

        System.out.println(doubleCheckSingleton == doubleCheckSingleton2);

        testThread();
    }


    public static void testThread() {
        for (int i=0;i<1000; i++) {
            new Thread(() -> {
                DoubleCheckSingleton doubleCheckSingleton = null;
                try {
                    doubleCheckSingleton = DoubleCheckSingleton.getDoubleCheckSingleton();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(doubleCheckSingleton);
            }).start();
        }
    }

}
