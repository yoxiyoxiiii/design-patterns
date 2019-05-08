package com.example.designpatterns.factory.simplefactory;

public class Worker implements Person {
    @Override
    public void hello() {
        System.out.println("worker hello");
    }
}
