package com.example.designpatterns.prototype;

import java.util.ArrayList;

/**
 * 深度克隆
 * 引用类型单独克隆
 */
public class PrototypeDemoDeepClone implements Cloneable{

    //基本数据类型
    private String name;
    //引用数据类型

    private ArrayList<String> list = new ArrayList<>();

    @Override
    public Object clone() throws CloneNotSupportedException {
        PrototypeDemoDeepClone clone = (PrototypeDemoDeepClone)super.clone();

        //深克隆
        clone.list = (ArrayList<String>)this.list.clone();
        return clone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeDemoDeepClone demoDeepClone = new PrototypeDemoDeepClone();
        PrototypeDemoDeepClone clone = (PrototypeDemoDeepClone)demoDeepClone.clone();
        demoDeepClone.list.add("add ");

        System.out.println(demoDeepClone.getList());// add
        System.out.println(clone.getList()); // []
        //结果不一样，说明通过克隆创建了两个独立的对象，浅克隆中内部的引用类型实际上是指向的同一个对象。



    }
}
