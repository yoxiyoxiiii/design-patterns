package com.example.designpatterns.singletons;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 内部类实现 单例
 * 内部类是延时加载的，静态内部类加载时也会加载外部类
 * 内部类在使用的时候加载
 */
public class InnerSingleton {

    private InnerSingleton() {
        if (Inner.innerSingleton !=null) {//防止暴力反射
            throw new RuntimeException("不要重复创建对象！");
        }

    }

    //该方法被调用时，内部类加载执行
    public static InnerSingleton getInstance() {
        return Inner.innerSingleton;
    }

    private static class Inner{
         private static final InnerSingleton innerSingleton = new InnerSingleton();
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        InnerSingleton instance = getInstance();
//        InnerSingleton instance2 = getInstance();
//
//        System.out.println(instance == instance2);
//
//        testThread();

        Class<?> clazz =InnerSingleton.class;

        //构造方法
        Constructor constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);//暴力访问
        Object newInstance = constructor.newInstance();
        Object newInstance2 = constructor.newInstance();
        System.out.println(newInstance == newInstance2);

    }

    public static void testThread () {
        for (int i = 0;i<1000; i++) {
            new Thread(()->{
                InnerSingleton instance = getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
