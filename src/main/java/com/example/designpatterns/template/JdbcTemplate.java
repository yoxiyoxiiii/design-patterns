package com.example.designpatterns.template;

/**
 * 模板设计模式:封装固定的步骤
 *
 */
public abstract class JdbcTemplate {

    //抽象方法，子类实现
    protected abstract String url();

    /**
     * 设置连接
     * 模板
     */
    private void connect() {
        String url = url();
        System.out.println("connect "+url+"success");
    }

    public void save() {
        connect();
        System.out.println("save 成功!");
    }
}
