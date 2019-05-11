package com.example.designpatterns.command;

public class Main {

    public static void main(String[] args) {
        Leader leader = new Leader();
        //leader 传入命令
        leader.excute("login");
        leader.excute("loginOut");
    }
}
