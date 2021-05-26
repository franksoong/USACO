package com.soong.starter;

public class A4_CommandlineIntro {
    // program arguments - how to source

    // - through run configuration

    // cd C:\Users\Administrator\eclipse-workspace\JavaStarter\bin
    // java com.soong.starter.A4_CommandlineIntro a 1 2

    // export as runnalbe jar
    // java -jar .\cal.jar a 5 4
    public static void main(String[] args) {
	basic2(args);
    }

    public static void basic(String[] args) {
	if (args.length < 1) {
	    System.out.println("No args provided");
	} else {
	    for (String arg : args) {
		System.out.println(arg);
	    }
	}
    }

    public static void basic2(String[] args) {
	if (args.length == 3) {
	    handleCommandLine(args);
	} else {
	    System.out.println("Please provide an operation code and 2 numeric values");
	}
    }

    private static void handleCommandLine(String[] args) {
	char opCode = args[0].charAt(0);
	double leftVal = Double.parseDouble(args[1]);
	double rightVal = Double.parseDouble(args[2]);

	double result = calcEngine(opCode, leftVal, rightVal);
	System.out.println(result);
    }

    static double calcEngine(char opCode, double leftVal, double rightVal) {
	double result;
	switch (opCode) {
	case 'a':
	    result = leftVal + rightVal;
	    break;
	case 's':
	    result = leftVal - rightVal;
	    break;
	case 'm':
	    result = leftVal * rightVal;
	    break;
	case 'd':
	    result = rightVal != 0 ? leftVal / rightVal : 0.0d;
	    break;
	default:
	    System.out.println("Invalid opCode: " + opCode);
	    result = 0.0d;
	    break;
	}
	return result;
    }

}
