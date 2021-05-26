package com.soong.starter;

/**
 * @author Administrator
 *
 */
public class A1_Basic {

    /**
     * @param args
     */
    public static void main(String[] args) {
	calcEngine();
    }

    public static void basicOperator() {
	int valA = 21;
	int valB = 6;
	int valC = 3;
	int valD = 1;

	int result1 = valA - valB / valC;
	int result2 = (valA - valB) / valC;

	System.out.println(result1);
	System.out.println(result2);

	int result3 = valA / valC * valD + valB;
	int result4 = valA / (valC * (valD + valB));

	System.out.println();
	System.out.println(result3);
	System.out.println(result4);

	System.out.println();
	System.out.println(valA);
	valA = valA + valC;
	valA += valC;
	System.out.println(valA);

	// valA -= valC;
	// valA *= valC;
	// valA /= valC;
    }

    public static void calcEngine() {
	double value1 = 100.0d;
	double value2 = 10.0d;
	double result = 0.0d;
	char opCode = 'd';

	switch (opCode) {
	case 'a':
	    result = value1 + value2;
	    break;
	case 's':
	    result = value1 - value2;
	    break;
	case 'm':
	    result = value1 * value2;
	    break;
	case 'd':
	    result = value2 != 0 ? value1 / value2 : 0.0d;
	    break;
	default:
	    System.out.println("Invalid opCode: " + opCode);
	    result = 0.0d;
	    break;
	}
	System.out.println(result);
	System.out.println();
    }

    public static void calcEngine3(double value1, double value2, char opCode) {
	double result = 0.0d;

	switch (opCode) {
	case 'a':
	    result = value1 + value2;
	    break;
	case 's':
	    result = value1 - value2;
	    break;
	case 'm':
	    result = value1 * value2;
	    break;
	case 'd':
	    result = value2 != 0 ? value1 / value2 : 0.0d;
	    break;
	default:
	    System.out.println("Invalid opCode: " + opCode);
	    result = 0.0d;
	    break;
	}
	System.out.println(result);
	System.out.println();
    }
}
