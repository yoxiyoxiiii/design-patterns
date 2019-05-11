package com.example.designpatterns.strategy;

/**
 * 微信支付
 */
public class WeiXinPay implements PayStrategy {
    @Override
    public void pay() {
        System.out.println("微信支付!");
    }
}
