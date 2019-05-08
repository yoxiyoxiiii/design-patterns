package com.example.designpatterns.factory.factorymethod;

/**
 * 工厂方法，通过具体的工厂来创建具体的对象，
 * 如 通过studentFactory 来创建student 对象。每种对象都交由自己的对应的工厂创建，扩展性交简单工作强
 * 缺点：每种对象都要求有自己的工厂
 */
public class Main {

    public static void main(String[] args) {
        PersonFactory studentFactory = new StudentFactory();
        Person person = studentFactory.createPerson();
        person.hello();

        PersonFactory workerFactory = new WorkerFactory();
        Person workerFactoryPerson = workerFactory.createPerson();
        workerFactoryPerson.hello();
    }
}
