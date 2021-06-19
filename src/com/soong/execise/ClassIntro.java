/**
 * 
 */
package com.soong.execise;

import java.util.ArrayList;
import java.util.Collections;

public class ClassIntro {
	static class Book implements Comparable<Book> {
		// attribute
		String name;
		int pages;
		String color;
		int current_page_in_reading = 0;

		// method
		public boolean goto_page(int page_num) {
			if (page_num < this.pages) {
				this.current_page_in_reading = page_num;
				System.out.println("in reading: " + this.current_page_in_reading);
				return true;
			} else {
				return false;
			}
		}

		public String toString() {
			return "{" + name + "," + pages + "," + color + "," + current_page_in_reading + "}";
		}

		@Override
		public int compareTo(Book o) {
			return this.pages - o.pages;

			// return this.name.compareTo(o.name);
		}
	}

	public static void main(String[] args) {
		//
		// Book book1 = new Book();
		// book1.name = "英语";
		// book1.pages = 100;
		// book1.color = "白色";
		// System.out.println(book1);
		// book1.goto_page(50);
		// System.out.println(book1);
		// System.out.println();
		//
		// Book book2 = new Book();
		// book2.name = "数学";
		// book2.pages = 200;
		// book2.color = "橙色";
		// book2.goto_page(100);
		// System.out.println(book2);

		ArrayList<Book> books = new ArrayList<Book>();

		Book book1 = new Book();
		book1.name = "egf";
		book1.pages = 1000;
		book1.color = "白色";

		Book book2 = new Book();
		book2.name = "def";
		book2.pages = 500;
		book2.color = "白色";

		Book book3 = new Book();
		book3.name = "abc";
		book3.pages = 100;
		book3.color = "白色";

		books.add(book1);
		books.add(book2);
		books.add(book3);

		System.out.println(books);

		Collections.sort(books);

		System.out.println(books);
	}

}
