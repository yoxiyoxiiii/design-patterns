package com.example.designpatterns.strategy;

/**
 * 策略模式 是对算法（如都是完成支付算法）的封装，如支付算法，达到在算法直接的自由切换的目的。
 * 同委派模式（命令模式）的根本区别是 命令模式 是封装的不同的算法（如登录和登出），通过命令来执行不同的算法。
 */
public class ContextStrategy implements PayStrategy{
    //持有策略应用，通过 Context 对象来切换各种策略
    private PayStrategy payStrategy;

    public ContextStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    //调用 传入的payStrategy 对象 执行对应的业务逻辑
    @Override
    public void pay() {
        payStrategy.pay();
    }

    public static void main(String[] args) {
        //微信支付
        PayStrategy payStrategy = new WeiXinPay();
        ContextStrategy contextStrategy = new ContextStrategy(payStrategy);
        contextStrategy.pay();

        //支付宝支持
        PayStrategy payStrategy1 = new ZfbPay();
        ContextStrategy contextStrategy1 = new ContextStrategy(payStrategy1);
        contextStrategy1.pay();
    }
}
