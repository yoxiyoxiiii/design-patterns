package com.example.designpatterns.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 命令发送者，或者说是 委派者，任务分发的作用
 */
public class Leader implements IExcuterCommand{

    private Map<String, IExcuterCommand> commandMap = new HashMap<>();
    public Leader() {
        //命令和 执行的执行者绑定
        commandMap.put("login", new IExcuterCommandLogin());
        commandMap.put("loginOut", new IExcuterCommandLoginOut());
    }

    /**
     * 通过command 将任务分发下去，让具体的执行者执行。
     * @param command
     */
    @Override
    public void excute(String command) {
        commandMap.get(command).excute(command);
    }
}
