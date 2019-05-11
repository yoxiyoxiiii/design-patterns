package com.example.designpatterns.strategy;

/**
 * 支付宝支付
 */
public class ZfbPay implements PayStrategy {
    @Override
    public void pay() {
        System.out.println("支付宝支付!");
    }
}
