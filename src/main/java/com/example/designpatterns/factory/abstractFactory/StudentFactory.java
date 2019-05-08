package com.example.designpatterns.factory.abstractFactory;

public class StudentFactory extends AbstractPersonFactory {
    @Override
    public Person getPerson() {
        return createPerson(Student.class);
    }
}
