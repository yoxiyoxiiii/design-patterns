package com.example.designpatterns.proxy;

/**
 * 被代理对象
 */
public class IUserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("save");
    }
}
