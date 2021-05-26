/**
 * 
 */
package com.soong.starter;

/**
 * @author Administrator
 *
 */
public class A3_MethodIntro {

    public static void main(String[] args) {
	double[] leftVals = { 100.0d, 25.0d, 225.0d, 11.0d, 11.0d };
	double[] rightVals = { 50.0d, 92.0d, 17.0d, 3.0d, 3.0d };
	char[] opCodes = { 'd', 'a', 's', 'm', 'm' };
	double[] results = new double[opCodes.length];

	for (int i = 0; i < opCodes.length; i++) {
	    results[i] = calcEngine(opCodes[i], leftVals[i], rightVals[i]);
	}

	for (double currentResult : results) {
	    System.out.println(currentResult);
	}

	double c = calcEngine('d', 100, 60);
	System.out.println(c);

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
