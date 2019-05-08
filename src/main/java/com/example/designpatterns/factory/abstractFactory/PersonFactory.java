package com.example.designpatterns.factory.abstractFactory;

/**
 * 抽象工作模式：核心就是 一个工厂中可以创建一类类似的对象
 */
public interface PersonFactory {

    Person createPerson(Class<? extends Person> personClazz);

    Person createBlackPerson();

    Person createStudent();
}
