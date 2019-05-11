package com.example.designpatterns.command;

/**
 * 实现登录功能
 */
public class IExcuterCommandLogin implements IExcuterCommand {
    @Override
    public void excute(String command) {
        System.out.println("收到login 命令，执行登录！");
    }
}
