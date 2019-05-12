package com.example.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 *
 * 设计模式总结：
 * 1.工厂模式：为创建者模式，可以结合反射无线的创建对象。
 * 2.单例模式：内存中只有一个对象，节约资源，保证数据的唯一。
 * 3.原型模式：属于创建者模式，通过克隆（浅克隆，深克隆）创建对象。
 * 4.代理模式：静态代理，jdk代理，cglib 代理。代理模式可以对目标对象的目标方法进进行功能增强扩展，真正干活的还是目标对象。
 * 5.委派模式（命令模式）：将任务分发给别人，通过命令然对应的对象做事。
 * 6.策略模式：对同一种算法进行封装，作到功能的自由切换，如支付功能，可以自由切换为微信和支付包。由使用者决定使用哪种策略算法。
 * 7.模式方法：封装公共的算法步骤，通过抽象方法（模板方法）暴露算法步骤中的不同，让子类实现。如jdbcTemplate。
 * 8. 适配器：现有的共能不能满足需求，如220V 的 需要转换为5V 的使用。重点是不破坏现有代码结构的基础上，通过组合或者继承的方式将功能转换为满足条件的最后功能。
 * 9.装饰者模式：对原因对象进行功能的增强或者功能的扩展。
 * 10.观察者模式：发布订阅模式
 */
@SpringBootApplication
public class DesignpatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignpatternsApplication.class, args);
    }

}
