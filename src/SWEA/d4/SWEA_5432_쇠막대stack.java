package SWEA.d4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432_쇠막대stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		// 좌괄호가 계속되면 막대가 지속, (다음에 바로 )가 오면 그건 레이저 -> 개수를 더해줘야함
		// 바로앞이 )이 아닌데 )가 나오면 막대가 하나 줄어드는 것
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			String input = sc.next();

			boolean prevIsLeft = false;
			int sum = 0;
			int bar = 0;
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c == '(') {
					// 좌괄호는 막대 or 레이저
					stack.push(c);

				} else if (c == ')' && (input.charAt(i - 1) == '(')) {

					// 레이저인 경우
					stack.pop();
					// bar가 1개씩 쪼개짐 -> bar의 개수만큼 sum에 추가
					sum += stack.size();

				} else {
					// 막대 하나가 끝남
					stack.pop();
					sum++;
				}

			}
			System.out.println("#" + (t + 1) + " " + sum);

		}
	}

}
