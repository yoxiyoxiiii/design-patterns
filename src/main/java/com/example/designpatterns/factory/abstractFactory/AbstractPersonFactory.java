package com.example.designpatterns.factory.abstractFactory;

/**
 * 抽象工作模式：核心就是 一个工厂中可以创建一类类似的对象
 */
public abstract class AbstractPersonFactory implements PersonFactory{

   public abstract Person getPerson();
    @Override
    public Person createPerson(Class<? extends Person> personClazz) {
        if (personClazz.equals(BlackPerson.class)) {
            return createBlackPerson();
        }
        if (personClazz.equals(Student.class)) {
            return createStudent();
        }
        return null;
    }

    @Override
    public Person createBlackPerson() {
        return new BlackPerson();
    }

    @Override
    public Person createStudent() {
        return new Student();
    }
}
