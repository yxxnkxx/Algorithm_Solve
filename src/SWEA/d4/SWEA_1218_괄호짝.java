package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class SWEA_1218_괄호짝 {
	static Stack<Character> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	static HashMap<Character, Character> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');
		map.put('>', '<');
		// key는 오른쪽, value는 왼쪽

		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			sb.append("#" + t + " ");
			command(input);
			stack.clear();
		}

		System.out.print(sb.toString());
	}

	static void command(String input) {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (map.values().contains(c)) { // 왼쪽 괄호
				stack.push(c);
			} else {
				if (stack.isEmpty() || map.get(c) != stack.peek()) {
					sb.append("0\n");
					return;
				}
				stack.pop();
			}

		}
		if (!stack.isEmpty()) {
			sb.append("0\n");
			return;
		}
		sb.append("1\n");
		return;
	}
}
