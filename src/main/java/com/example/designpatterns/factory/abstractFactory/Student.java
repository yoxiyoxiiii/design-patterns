package com.example.designpatterns.factory.abstractFactory;

public class Student implements Person {
    @Override
    public void hello() {
        System.out.println("student hello");
    }
}
