/*
ID: xinkun.2
LANG: JAVA
TASK: test
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class test {
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("test.in"));
		PrintWriter writer = new PrintWriter(new File("test.out"));

		int num1 = reader.nextInt(); // 3
		int num2 = reader.nextInt(); // 4

		int sum = num1 + num2;

		writer.println(sum);
		writer.close();
		reader.close();
	}
}