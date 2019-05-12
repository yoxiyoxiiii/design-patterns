package com.example.designpatterns.Adapter;

/*
 * 语言适配器:
 * 适配器模式：原来的功能不满足需求，
 * 将一个类的接口适配成用户所期待的
 */
public class LanguageAdapter extends EnglishImpl implements Chinese {

    /**
     * 英文转换成中文
     * @return
     */
    @Override
    public String helloChiness() {
        String hello = super.helloEnglish();
        if ("hello".equals(hello))
        return "你好!";
        return hello;
    }

    public static void main(String[] args) {
        Chinese chinese = new LanguageAdapter();
        String helloChiness = chinese.helloChiness();
        System.out.println(helloChiness);
    }
}
