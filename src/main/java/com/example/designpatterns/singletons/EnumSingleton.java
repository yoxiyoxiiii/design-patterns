package com.example.designpatterns.singletons;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * 枚举式单例
 * 前面的所有的实现方式，都避免不了 暴力反射和序列化问题
 * 推荐使用枚举
 */
public enum  EnumSingleton {

    INSTANCE;
   public EnumSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
//        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
//
//        System.out.println(enumSingleton == enumSingleton2);
        
        //测试暴力反射
        Class<?> c = EnumSingleton.class;
        //这句就抛出异常了。有效防止暴力反射
        Constructor<?> declaredConstructor = c.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//暴力访问
        Object newInstance = declaredConstructor.newInstance();
        System.out.println(newInstance);
    }


}
