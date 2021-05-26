package com.soong.starter;

import java.util.HashMap;

/*
1:Map
(1)Map的特点
	是由键和值组成的。每一个元素是一个键值对，由两部分组成。
	键唯一，值可以重复。
	它的实现类的数据结构只针对键有效，跟值无关。
(2)Map和Collection的区别?
	A:Map双列集合，由键值对组成；键唯一，值可以重复；数据结构针对键有效
	B:Collection单列集合，有单个元素组成；Set唯一，List可重复；数据结构针对元素有效
(3)Map的功能概述
	A:添加功能
		put
	B:移除功能
		remove
		clear
	C:判断功能
		containsKey,containsValue
		isEmpty
	D:获取功能
		size
		get
		keySet
		values
		entrySet
*/

public class A7_MapIntro {

    public static void main(String[] args) {
	basic();
    }

    public static void basic() {
	HashMap<String, String> address_book = new HashMap<String, String>();

	// add
	address_book.put("Dave", "HuntingtonBeach, CA");
	address_book.put("Luce", "Spencer, IN");
	address_book.put("Alice", "Roundup, MT");

	// traversal
	for (String key : address_book.keySet()) {
	    String value = address_book.get(key);
	    System.out.println(key + "->" + value);
	}
	System.out.println("---------------------");

	// modify
	address_book.put("Alice", "EastHampton, NY");
	address_book.remove("Luce");
	address_book.put("Bob", "Richmond, VA");

	for (String key : address_book.keySet()) {
	    String value = address_book.get(key);
	    System.out.println(key + "->" + value);
	}
	System.out.println("---------------------");

    }

}
