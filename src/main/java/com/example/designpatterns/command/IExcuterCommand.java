package com.example.designpatterns.command;

/**
 * 委派模式（命令模式）：自己不做，通过command 让具体的实现者完成相应的功能
 * spring mvc 的 dispatchServlet 就是使用命令模式（委派模式）实现请求的任务分发。
 */
public interface IExcuterCommand {

    void excute(String command);
}
