package com.example.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 动态代理：必须要实现接口
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 */
public class JdkProxy implements InvocationHandler {

    //目标对象
    private Object target;
    public JdkProxy(){}

    public JdkProxy(Object target) {
        this.target =target;
    }

    /**
     * 利用反射执行目标对象的目标方法。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        Object invoke = method.invoke(target, args);
        System.out.println("提交事务");
        return invoke;
    }


    /**
     * 生成代理对象
     * @return
     */
    public Object getInstance() {
        Object newProxyInstance = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),// 指定当前目标对象使用类加载器,获取加载器的方法是固定的
                target.getClass().getInterfaces(),//目标对象实现的接口的类型,使用泛型方式确认类型
                this); //事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
        return newProxyInstance;
    }

    public static void main(String[] args) {
        IUserDao iUserDao = new IUserDaoImpl();
        JdkProxy jdkProxy = new JdkProxy(iUserDao);
        IUserDao proxyInstance = (IUserDao)jdkProxy.getInstance();
        proxyInstance.save();
    }
}
