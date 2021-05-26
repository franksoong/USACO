package com.soong.starter;

public class A2_ArrayIntro {

    public static void main(String[] args) {
	calcEngine();
    }

    public static void basic() {
	float[] theVals1 = new float[3];
	theVals1[0] = 10.0f;
	theVals1[1] = 20.0f;
	theVals1[2] = 15.0f;

	float sum1 = 0.0f;
	// init, terminate condition, step
	for (int index = 0; index < theVals1.length; index++) {
	    System.out.println("current index:" + index);
	    System.out.println("current condition: " + (index < theVals1.length) + "\n");
	    sum1 += theVals1[index];
	}

	System.out.println("exit loop");
	System.out.println(sum1); // displays 45
    }

    public static void basic2() {
	float[] theVals1 = { 10.0f, 20.0f, 15.0f };

	float sum1 = 0.0f;
	for (float currentVal1 : theVals1) {
	    sum1 += currentVal1;
	}
	System.out.println(sum1); // displays 45
    }

    // loops and arrays
    public static void calcEngine() {
	double[] leftVals = { 100.0d, 25.0d, 225.0d, 11.0d };
	double[] rightVals = { 50.0d, 92.0d, 17.0d, 3.0d };
	char[] opCodes = { 'd', 'a', 's', 'm' };

	double[] results = new double[opCodes.length];

	for (int i = 0; i < opCodes.length; i++) {
	    switch (opCodes[i]) {
	    case 'a':
		results[i] = leftVals[i] + rightVals[i];
		break;
	    case 's':
		results[i] = leftVals[i] - rightVals[i];
		break;
	    case 'm':
		results[i] = leftVals[i] * rightVals[i];
		break;
	    case 'd':
		results[i] = rightVals[i] != 0 ? leftVals[i] / rightVals[i] : 0.0d;
		break;
	    default:
		System.out.println("Invalid opCode: " + opCodes[i]);
		results[i] = 0.0d;
		break;
	    }
	}

	for (double currentResult : results) {
	    System.out.println(currentResult);
	}
    }

}
