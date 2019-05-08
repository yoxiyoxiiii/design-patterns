package com.example.designpatterns.factory.abstractFactory;

public class BlackPersonFactory extends AbstractPersonFactory {

    @Override
    public Person getPerson() {
        return createPerson(BlackPerson.class);
    }
}
