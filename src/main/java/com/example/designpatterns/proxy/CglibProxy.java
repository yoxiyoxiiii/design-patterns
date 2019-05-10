package com.example.designpatterns.proxy;

import javafx.beans.binding.ObjectExpression;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用Cglib 实现动态代理
 * 目标对象不需要实现接口
 * 实现 MethodInterceptor 接口
 */
public class CglibProxy implements MethodInterceptor {

    //目标对象
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    /**
     * 拦截intercept
     * @param o
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object returnValue  = method.invoke(target, args);
        System.out.println("提交事务");
        return returnValue;
    }

    //给目标对象创建一个代理对象
    public Object getInstance() {
        //1.工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调
        enhancer.setCallback(this);
        //创建代理对象
        Object instance = enhancer.create();
        return instance;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        CglibProxy cglibProxy = new CglibProxy(userDao);
        UserDao proxyInstance = (UserDao) cglibProxy.getInstance();
        proxyInstance.save();
    }
}
