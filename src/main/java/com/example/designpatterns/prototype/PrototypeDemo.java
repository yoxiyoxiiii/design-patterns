package com.example.designpatterns.prototype;

import java.util.Date;

/**
 * 原型设计模式：就是以原来的对象通过 克隆 生成新对象，以原来的对象作为“原型”。
 * 深度克隆
 * 浅克隆
 * 实现方式：实现 Cloneable 接口 clone 方法
 * 1、实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
 *
 * 2、重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此，Prototype类需要将clone方法的作用域修改为public类型。
 *
 * 原型模式是一种比较简单的模式，也非常容易理解，实现一个接口，重写一个方法即完成了原型模式。
 * 在实际应用中，原型模式很少单独出现。经常与其他模式混用，他的原型类Prototype也常用抽象类来替代
 *
 *
 * 原型模式-深浅拷贝：
 * 浅拷贝：只复制一个对象，对象内部存在的指向其他对象数组或者引用则不复制。也就是只能拷贝对象内部的基本数据类型的属性，对与对象的引用，数组，不做拷贝。
 * 深拷贝：对象，对象内部的引用均复制。
 *
 * Object类的clone方法只会拷贝对象中的基本的数据类型，
 * 对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。
 * 如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝
 */
public class PrototypeDemo implements Cloneable{

    //基本数据类型
    private String name;

    //引用类型
    private Date birthday;

    public PrototypeDemo() {}
    public PrototypeDemo(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    //直接使用 Object 的 clone() 方法，实现浅克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(123123123123L);
        PrototypeDemo prototypeDemo = new PrototypeDemo("hello" ,date);
        //克隆生成的对象
        PrototypeDemo clone =(PrototypeDemo) prototypeDemo.clone();

        System.out.println(prototypeDemo.getBirthday());
        System.out.println(clone.getBirthday()); //相同值

        date.setTime(234234234L);//修改时间后

        System.out.println(prototypeDemo.getBirthday());
        System.out.println(clone.getBirthday());//相同值

//        可以看出，浅拷贝后，原型对象中的引用类型值改变，
//        拷贝的对象引用类型的值也跟着变化，
//        实际上浅拷贝的对象内部引用类型对象和原型对象内部的引用类型对象指向同一引用。
//        clone这种对象的时候需要注意，如果希望拷贝的对象不受原型对象的影响，浅拷贝就不适用了。


    }
}
