package com.example.designpatterns.factory.factorymethod;

public class StudentFactory implements PersonFactory {
    @Override
    public Person createPerson() {
        return new Student();
    }
}
