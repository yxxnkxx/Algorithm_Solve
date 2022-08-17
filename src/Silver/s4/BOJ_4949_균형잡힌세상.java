package Silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		while (!input.equals(".")) {
			if (check(input))
				System.out.println("yes");
			else
				System.out.println("no");
			input = br.readLine();
		}
	}

	static boolean check(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(' || c == '[')
				stack.push(c); // 왼쪽 괄호일 때는 push
			else if (c == ')' || c == ']') {
				if (stack.isEmpty())
					return false;
				// 오른쪽 괄호인데 stack이 비어 있으면 false
				if (c == ')' && stack.peek() == '(')
					stack.pop(); // 오른쪽 괄호일 때 peek가 (이면 pop
				else if (c == ']' && stack.peek() == '[')
					stack.pop();
				else
					return false; // 짝이 안 맞는 경우

			}
		}
		if (!stack.isEmpty())
			return false;// for문이 끝나고 stack이 비어있지 않으면 false
		return true;
	}

}
