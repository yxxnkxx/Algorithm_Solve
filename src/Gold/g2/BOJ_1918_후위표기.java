package Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BOJ_1918_후위표기 {
	static Stack<Character> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		HashMap<Character, Integer> operator = new HashMap<>();
		operator.put('+', 1); // 우선순위
		operator.put('-', 1);
		operator.put('*', 2);
		operator.put('/', 2);
		operator.put('(', 0);
		operator.put(')', 0);

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '(')
				stack.push(c); // 좌괄호는 그냥 push

			// 우괄호는 좌괄호가 나올 때까지 pop하여 sb에 추가
			else if (c == ')') {
				while (stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop(); // 좌괄호는 그냥 pop
			}

			else if (operator.containsKey(c)) {

				if (stack.isEmpty()) // 비어 있으면 push
					stack.push(c);
				else {
					// 비어있지 않으면 stack의 peek의 우선순위가 자신보다 크거나 같으면 pop
					// 작을때는 그냥 push
					while (!stack.isEmpty() && operator.get(c) <= operator.get(stack.peek())) {
						sb.append(stack.pop());
					}
					stack.push(c);
				}

			} else { // 연산자가 아닐 때 출력
				sb.append(c);
			}
		}

		while (!stack.isEmpty()) // stack에 있는 것 모두 pop
			sb.append(stack.pop());

		System.out.println(sb.toString());

	}

}
