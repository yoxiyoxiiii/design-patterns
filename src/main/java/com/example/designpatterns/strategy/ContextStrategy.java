package com.example.designpatterns.strategy;

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
