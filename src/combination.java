import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class combination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String numString = "52323423423";
		HashMap<Character, char[]> keypad = get_keypad();
		ArrayList<String> names = generate_combination(numString, keypad);

		System.out.println(names.size());
		// names.forEach((item) -> {
		// System.out.println(item);
		// });
	}

	public static ArrayList<String> generate_combination(String num, HashMap<Character, char[]> keypad) {
		ArrayList<String> names = new ArrayList<String>();

		int len = num.length();

		// problem1: 1
		char key = num.charAt(0);
		char[] problem1 = keypad.get(key);
		ArrayList<String> problem1_result = new ArrayList<String>();
		for (char c : problem1) {
			problem1_result.add(String.valueOf(c));
		}

		// basic
		if (len == 1) {
			return problem1_result;
		}

		// problem2: len-1
		String sub_num = num.substring(1);
		ArrayList<String> problem2 = generate_combination(sub_num, keypad);

		for (String p1 : problem1_result) {
			for (String p2 : problem2) {
				String item = p1 + p2;
				names.add(item);
			}
		}

		return names;
	}

	public static HashMap<Character, char[]> get_keypad() {
		HashMap<Character, char[]> keypad = new HashMap<Character, char[]>();
		keypad.put('2', new char[] { 'A', 'B', 'C' });
		keypad.put('3', new char[] { 'D', 'E', 'F' });
		keypad.put('4', new char[] { 'G', 'H', 'I' });
		keypad.put('5', new char[] { 'J', 'K', 'L' });
		keypad.put('6', new char[] { 'M', 'N', 'O' });
		keypad.put('7', new char[] { 'P', 'R', 'S' });
		keypad.put('8', new char[] { 'T', 'U', 'V' });
		keypad.put('9', new char[] { 'W', 'X', 'Y' });

		return keypad;
	}

	// only can process id length as 4
	public static void naive(String numString) {
		HashMap<Character, char[]> keypad = get_keypad();
		ArrayList<String> names = new ArrayList<String>();

		// naive
		// only can process id length as 4
		char key1 = numString.charAt(0);
		char key2 = numString.charAt(1);
		char key3 = numString.charAt(2);
		char key4 = numString.charAt(3);
		// char key5 = numString.charAt(4);

		char[] chars1 = keypad.get(key1);
		char[] chars2 = keypad.get(key2);
		char[] chars3 = keypad.get(key3);
		char[] chars4 = keypad.get(key4);
		// char[] chars5 = keypad.get(key5);

		for (int j1 = 0; j1 < chars1.length; j1++) {
			for (int j2 = 0; j2 < chars2.length; j2++) {
				for (int j3 = 0; j3 < chars3.length; j3++) {
					for (int j4 = 0; j4 < chars4.length; j4++) {
						// for (int j5 = 0; j5 < chars5.length; j5++) {
						String name = "" + chars1[j1] + chars2[j2] + chars3[j3] + chars4[j4]; // + chars5[j5];
						names.add(name);
						// }
					}
				}
			}
		}

		names.forEach((item) -> {
			System.out.println(item);
		});

	}

}
