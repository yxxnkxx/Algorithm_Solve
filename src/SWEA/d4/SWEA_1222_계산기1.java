package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1222_계산기1 {
	static Stack<Character> stack = new Stack<>();
	static Stack<Integer> cal = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringBuilder postfix = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				Character c = input.charAt(i);
				if (c >= '0' && c <= '9')
					postfix.append(c);
				else {
					if (!stack.isEmpty())
						postfix.append(stack.pop()); // +밖에 없으니까 우선순위 고려x
					stack.push(c);
				}
			}
			while (!stack.isEmpty())
				postfix.append(stack.pop());

			/////////////////////// postfix
			String post = postfix.toString();
			for (int i = 0; i < post.length(); i++) {
				char c = post.charAt(i);
				if (c >= '0' && c <= '9')
					cal.push(c - '0');
				else {
					int num1 = cal.pop();
					int num2 = cal.pop();
					cal.push(num1 + num2);
				}
			}
			System.out.println("#" + t + " " + cal.pop());
		}

	}
}
