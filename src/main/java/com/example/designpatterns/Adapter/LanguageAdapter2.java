package com.example.designpatterns.Adapter;

/*
 * 语言适配器:
 * 适配器模式：原来的功能不满足需求，
 * 将一个类的接口适配成用户所期待的
 * 组合方式实现，重点是功能转换
 */
public class LanguageAdapter2  implements Chinese {

    private English english;

    private LanguageAdapter2(English english) {
        this.english = english;
    }
    @Override
    public String helloChiness() {
        if(english.helloEnglish().equals("hello")) {
            return "你好!";
        }
        return "hello";
    }

    public static void main(String[] args) {
        English english = new EnglishImpl();
        Chinese chinese = new LanguageAdapter2(english);
        String hello = chinese.helloChiness();
        System.out.println(hello);
    }
}
