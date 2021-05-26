import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
ID: xinkun.2
LANG: JAVA
TASK: namenum
*/

public class namenum_v2 {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("namenum.in"));
		PrintWriter writter = new PrintWriter(new File("namenum.out"));

		long start = System.currentTimeMillis();
		HashMap<String, Boolean> dict = read_dict();
		long end = System.currentTimeMillis();
		System.out.println("read_dict: " + (end - start));

		String number = reader.next();
		ArrayList<String> result = solve(number, dict);

		if (result == null || result.size() == 0) {
			writter.println("NONE");
		} else {
			result.forEach((item) -> {
				writter.println(item);
			});
		}

		writter.close();
		reader.close();
	}

	private static ArrayList<String> solve(String number, HashMap<String, Boolean> dict) {
		ArrayList<String> result = new ArrayList<String>();

		// 1, generate combinations
		// 2, complete search - dict

		HashMap<Character, char[]> keypad = get_keypad();

		long start = System.currentTimeMillis();
		ArrayList<String> all = generate_combination(number, keypad);
		long end = System.currentTimeMillis();
		System.out.println("generate_combination: " + (end - start));

		start = System.currentTimeMillis();
		for (String name : all) { // 6W
			// if (dict.contains(name)) { // 5K
			// result.add(name);
			// }
			if (dict.containsKey(name)) { // 1
				result.add(name);
			}
		}

		end = System.currentTimeMillis();
		System.out.println("search: " + (end - start));

		return result;
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

	/**
	 * @throws FileNotFoundException
	 */
	public static HashMap<String, Boolean> read_dict() throws FileNotFoundException {
		Scanner reader2 = new Scanner(new File("dict.txt"));
		HashMap<String, Boolean> dict = new HashMap<String, Boolean>();

		while (reader2.hasNext()) {
			dict.put(reader2.next(), true);
		}

		return dict;

	}

}
