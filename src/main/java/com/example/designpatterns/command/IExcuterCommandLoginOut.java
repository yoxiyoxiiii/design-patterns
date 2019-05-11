package com.example.designpatterns.command;

/**
 * 实现登出功能
 */
public class IExcuterCommandLoginOut implements IExcuterCommand {
    @Override
    public void excute(String command) {
        System.out.println("接受到 loginOut 命令，执行登出操作!");
    }
}
