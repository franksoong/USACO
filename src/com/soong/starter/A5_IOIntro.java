package com.soong.starter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
/**
 * 
 */
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class A5_IOIntro {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	// testCommandIO();
	// testCommandIO2();

	// testCommandIO2();

	// testFileIO1();
	testFileIO2();
    }

    public static void testCommandIO() {
	Scanner scanner = new Scanner(System.in);

	System.out.println("Please input 2 numbers\n");
	float height = scanner.nextFloat();
	float length = scanner.nextFloat();

	float area = AREA(height, length);
	System.out.println("area is: " + area);
    }

    public static void testCommandIO2() {
	Scanner sc = new Scanner(System.in);

	// Infinite version
	// source Negative number to exit
	System.out.println("Please input 2 numbers\n");

	boolean condition = true;
	while (condition) {
	    float height = sc.nextFloat();
	    float length = sc.nextFloat();

	    condition = height > 0 && length > 0;
	    if (condition) {
		float area = AREA(height, length);
		System.out.println("area is: " + area + "\n");
	    } else {
		System.out.println("Condition is false, program will exit while loop\n");
	    }
	}

	System.out.println("Program exited!\n");
    }

    public static float AREA(float height, float length) {
	return height * length;
    }

    public static void testFileIO1() throws Exception {
	String readfilePath = "hello_in.txt";
	String writefilePath = "hello_out.txt";

	/*
	 * 使用FileReader读取源文件，使用FileWriter向目标文件中写数据。 依次从源文件中读取字符，然后写入目标文件，完成复制操作。
	 */
	FileReader reader = new FileReader(readfilePath);
	FileWriter writer = new FileWriter(writefilePath, true); // 再次执行时会追加，文件变大

	// 按照字节来读写
	char[] b = new char[1204];
	int len = -1;
	while ((len = reader.read(b)) != -1) {
	    System.out.println("Process " + b);
	    writer.write(b, 0, len);
	}

	reader.close();
	writer.close();
	System.out.println("完成复制");
    }

    public static void testFileIO2() throws Exception {
	String readfilePath = "hello_in.txt";
	String writefilePath = "hello_out.txt";

	FileReader reader = new FileReader(readfilePath);
	BufferedReader bufferedReader = new BufferedReader(reader);

	FileWriter fileOutputStream = new FileWriter(writefilePath);
	BufferedWriter bufferedWriter = new BufferedWriter(fileOutputStream);

	// 按照行来读写
	String line = null;
	while ((line = bufferedReader.readLine()) != null) {
	    System.out.println("Process " + line);
	    line = line + line;
	    bufferedWriter.write(line);
	    bufferedWriter.newLine();// 写换行符
	}

	bufferedReader.close();
	bufferedWriter.close();

	System.out.println("Done");
    }

    // ignore //////////////////////////
    public static void testFileIO11() throws Exception {
	String readfilePath = "hello_in.txt";
	String writefilePath = "hello_out.txt";

	/*
	 * 使用FileInputStream读取源文件，使用FileOutputStream向目标文件中写数据。
	 * 依次从源文件中读取字节，然后写入目标文件，完成复制操作。
	 */
	// 字节流：以字节为单位进行数据操作 FileInputStream/FileOutputStream
	// 字符流：以字符为单位进行数据操作 FileReader/FileWriter
	FileInputStream fis = new FileInputStream(readfilePath);
	FileOutputStream fos = new FileOutputStream(writefilePath, true); // 再次执行时会追加，文件变大

	// 按照字节来读写
	byte[] b = new byte[1204 * 10];
	int len = -1;
	while ((len = fis.read(b)) != -1) {
	    System.out.println("Process " + b);
	    fos.write(b, 0, len);
	}

	fis.close();
	fos.close();
	System.out.println("完成复制");
    }

    public static void testFileIO12() throws Exception {
	String readfilePath = "hello_in.txt";
	String writefilePath = "hello_out.txt";

	FileInputStream fileInputStream = new FileInputStream(readfilePath);
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

	// append mode
	FileOutputStream fileOutputStream = new FileOutputStream(writefilePath, true);
	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

	// 按照行来读写
	String line = null;
	while ((line = bufferedReader.readLine()) != null) {
	    System.out.println("Process " + line);
	    bufferedWriter.write(line);
	    bufferedWriter.newLine();// 写换行符
	}

	bufferedReader.close();
	bufferedWriter.close();

	System.out.println("Done");
    }
}
