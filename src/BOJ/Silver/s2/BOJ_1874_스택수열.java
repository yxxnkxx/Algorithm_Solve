package BOJ.Silver.s2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int cnt = 0; // stack에 push할 변수
		stack.push(0); // empty 스택 방지
		for (int i = 0; i < N; i++) {
			while (stack.peek() < arr[i]) { // num과 같아질 때까지 push
				stack.push(++cnt);
				sb.append("+\n");
			}
			if (stack.peek() == arr[i]) { // 같으면 pop
				stack.pop();
				sb.append("-\n");
			} else if (stack.peek() > arr[i]) { // peek이 num보다 크면 불가능
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb.toString());

	}

}
