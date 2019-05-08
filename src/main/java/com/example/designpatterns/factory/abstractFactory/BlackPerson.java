package com.example.designpatterns.factory.abstractFactory;

public class BlackPerson implements Person{
    @Override
    public void hello() {
        System.out.println("black person hello");
    }
}
