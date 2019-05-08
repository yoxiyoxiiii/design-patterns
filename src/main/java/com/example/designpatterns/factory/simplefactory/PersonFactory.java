package com.example.designpatterns.factory.simplefactory;

/**
 *
 * 简单工作模式
 */
public class PersonFactory {

    public static Person createPerson(Class<? extends Person> personClass) {
        //根据类型创建对应的对象，
        // 特点：这种方式必须要求有一个 共同的接口或者父类；
        // 当有其他 Person 子类需要创建时，必须修改Factory对象，扩展性不强
        if (personClass .equals(Student.class)){
            return new Student();
        }

        if (personClass.equals(Worker.class)) {
            return new Worker();
        }
        return null;
    }

    public static void main(String[] args) {
        Person person = PersonFactory.createPerson(Student.class);
        person.hello();

        Person workerPerson = PersonFactory.createPerson(Worker.class);
        workerPerson.hello();
    }
}
