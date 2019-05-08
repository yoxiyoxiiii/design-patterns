package com.example.designpatterns.factory.factorymethod;

public class WorkerFactory implements PersonFactory {
    @Override
    public Person createPerson() {
        return new Worker();
    }
}
