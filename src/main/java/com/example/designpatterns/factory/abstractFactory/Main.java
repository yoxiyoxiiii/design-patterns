package com.example.designpatterns.factory.abstractFactory;

public class Main {

    public static void main(String[] args) {
        BlackPersonFactory blackPersonFactory = new BlackPersonFactory();
        Person person = blackPersonFactory.getPerson();
        person.hello();

        StudentFactory studentFactory = new StudentFactory();
        Person studentFactoryPerson = studentFactory.getPerson();
        studentFactoryPerson.hello();
    }
}
