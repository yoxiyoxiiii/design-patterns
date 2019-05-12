package com.example.designpatterns.observer;


public class Main {

    public static void main(String[] args) {
        TeacherSubject subject = new TeacherSubject();
        StudentObserver studentObserver = new StudentObserver();
        subject.addObserver(studentObserver);
        subject.setHomework("hello");
    }
}
