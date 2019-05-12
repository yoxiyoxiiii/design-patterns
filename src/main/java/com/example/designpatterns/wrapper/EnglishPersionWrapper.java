package com.example.designpatterns.wrapper;

/**
 * 装饰者模式 主要是在原来的功能基础上对功能进行增强!
 *
 * 适配器模式主要是对原有的功能进行功能转换。
 */
public class EnglishPersionWrapper implements Person {

    private Person englishPersion;
    public EnglishPersionWrapper(Person englishPersion) {
        this.englishPersion = englishPersion;
    }

    @Override
    public String sayHello() {
        System.out.println("功能增强!");
        return englishPersion.sayHello() +" world!";
    }

    public static void main(String[] args) {
        Person englishPersion = new EnglishPersion();
        Person person = new EnglishPersionWrapper(englishPersion);
        String sayHello = person.sayHello();
        System.out.println(sayHello);
    }
}
