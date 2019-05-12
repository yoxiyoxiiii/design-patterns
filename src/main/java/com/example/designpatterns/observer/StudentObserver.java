package com.example.designpatterns.observer;

public class StudentObserver implements Observer {

    @Override
    public void update(String info) {
        System.out.println("得到作业:"+info);
    }
}
