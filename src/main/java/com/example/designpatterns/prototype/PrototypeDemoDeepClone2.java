package com.example.designpatterns.prototype;

import java.io.*;
import java.util.ArrayList;

/**
 * 深度克隆
 * 引用类型单独克隆
 * 通过序列化和反序列化实现深度克隆
 */
public class PrototypeDemoDeepClone2 implements Cloneable, Serializable {

    //基本数据类型
    private String name;
    //引用数据类型

    private ArrayList<String> list = new ArrayList<>();

    public PrototypeDemoDeepClone2 deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //对象序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        //反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        //创建对象
        PrototypeDemoDeepClone2 object = (PrototypeDemoDeepClone2)objectInputStream.readObject();
        return object;
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

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        PrototypeDemoDeepClone2 demoDeepClone = new PrototypeDemoDeepClone2();
        PrototypeDemoDeepClone2 clone = demoDeepClone.deepClone();
        demoDeepClone.list.add("add ");

        System.out.println(demoDeepClone.getList());// add
        System.out.println(clone.getList()); // []
        //结果不一样，说明通过克隆创建了两个独立的对象，浅克隆中内部的引用类型实际上是指向的同一个对象。



    }
}
