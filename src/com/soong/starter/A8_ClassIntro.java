package com.soong.starter;

/*
我们要想通过编程语言来描述事物，首先要知道，事物是如何表达的：
事物：
	属性	该事物的描述信息(外在特征)
	行为	该事物能够做什么(内在行为)

类：
	成员变量	该事物的描述信息(外在特征)
	成员方法	该事物能够做什么(内在行为)

类： 是一组相关的属性和行为的集合  - 工厂， 分类，模板
对象：是该类事物的具体体现       - 产品


举例：
 学生是类
 张三是对象
*/

public class A8_ClassIntro {
    public static void main(String[] args) {
	test1();
    }

    public static void test1() {
	Student student = new Student();
	student.sid = "001";
	student.name = "Dave";
	student.age = 15;
	student.study();
	student.eat();
    }
}

class Student {
    // 成员变量
    // 学号
    String sid;
    // 姓名
    String name;
    // 年龄
    int age;

    public void Student() {
	// nothing
    }

    public void Student(String sid, String name, int age) {
	this.sid = sid;
	this.name = name;
	this.age = age;
    }

    // 成员方法
    // 学习的方法
    public void study() {
	System.out.println(this.name + "爱学习");
    }

    // 吃饭的方法
    public void eat() {
	System.out.println(this.name + "要吃饭");
    }

    // 睡觉的方法
    public void sleep() {
	System.out.println(this.name + "想睡觉");
    }
}

class Phone {
    // 品牌
    String brand;
    // 价格
    int price;
    // 颜色
    String color;

    // 打电话的方法
    public void call(String name) {
	System.out.println("给" + name + "打电话");
    }

    // 发短信的方法
    public void sendMessage() {
	System.out.println("群发短信");
    }
}
