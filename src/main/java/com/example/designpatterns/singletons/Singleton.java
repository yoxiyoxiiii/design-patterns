package com.example.designpatterns.singletons;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式
 * 最简单的懒汉式
 * 存在线程安全问题
 */
public class Singleton {

    //构造函数私有
    private Singleton() {}

    private static Singleton singleton = null;
    //对外提供访问接口
    public static Singleton getInstance() throws InterruptedException {
        if (singleton == null) {
            //线程休眠，模拟多线线程下的安全问题
            TimeUnit.SECONDS.sleep(2);
          singleton = new Singleton();
        }
        return singleton;

    }

    public static void main(String[] args) throws InterruptedException {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);
        testThread();
    }

    /**
     *  多线程 条件下线程不安全，返回的不是同一个对象
     */
    public static void testThread() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Singleton instance = null;
                try {
                    instance = Singleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(instance);
            }).start();
        }
    }
}
