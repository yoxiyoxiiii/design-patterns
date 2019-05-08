package com.example.designpatterns.factory.factorymethod;

public class Worker implements Person {
    @Override
    public void hello() {
        System.out.println("hello worker");
    }
}
