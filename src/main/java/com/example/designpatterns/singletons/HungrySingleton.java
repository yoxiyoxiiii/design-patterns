package com.example.designpatterns.singletons;

/**
 * 饿汉式 处理线程安全问题方法之一
 * 缺点：消耗资源
 */
public class HungrySingleton {

    private HungrySingleton(){}
    //直接在类加载阶段就初始化
    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();

        System.out.println(instance == instance2);

        testThread();
    }


    /**
     * 多线情况
     */
    public static void  testThread() {
        for (int i = 0 ;i<1000; i++) {
            new Thread(()->{
                HungrySingleton instance = HungrySingleton.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
