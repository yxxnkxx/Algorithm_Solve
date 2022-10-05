package BOJ.Gold.g4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16637_괄호추가 {
	static int N;
	static char[] op;
	static int[] nums;
	static boolean[] pick;
	static int ans;
	static final int INF = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String str = sc.next();
		op = new char[N / 2];
		nums = new int[N / 2 + 1];
		for (int i = 0; i < N / 2; i++) {
			nums[i] = str.charAt(i * 2) - '0';
			op[i] = str.charAt(i * 2 + 1);
		}
		nums[N / 2] = str.charAt(N - 1) - '0';
		ans = Integer.MIN_VALUE;
		pick = new boolean[N / 2];// 연산자를 스택에 넣기-괄호로 뽑혔는지 아닌지 조회함
		// 괄호의 개수 = 부분집합
		pickOp(0);
		System.out.println(ans);
	}

	static void pickOp(int depth) {
		if (depth == N / 2) {
			ans = Math.max(ans, find());
			return;
		}

		if (depth != 0 && !pick[depth - 1]) {
			pick[depth] = true;
			pickOp(depth + 1);
		}
		pick[depth] = false;
		pickOp(depth + 1);
	}

	static int find() {
		int[] copy = nums.clone();

		// queue에 연산자 넣기, pick이 있다면 그거부터 넣음
		Queue<Integer> ops = new LinkedList<>();
		for (int i = 0; i < pick.length; i++)
			if (pick[i]) // 먼저 계산
			{
				nums[i] = cal(nums[i], nums[i + 1], op[i]);
				nums[i + 1] = INF;
			}

		for (int i = 0; i < pick.length; i++)
			if (!pick[i])
				ops.add(i); // 나중에 계산
		// 계산이 쉽도록 op의 index를 넣음, op[i] 는 nums[i]와 nums[i+1]의 계산 결과
		while (!ops.isEmpty()) {
			int tmp = ops.poll();
			int a = (nums[tmp] == INF) ? nums[tmp - 1] : nums[tmp];
			int b = (nums[tmp + 1] == INF) ? nums[tmp] : nums[tmp + 1];
			nums[tmp + 1] = cal(a, b, op[tmp]); // 원래는 앞에서부터하니까
		}
		int ans = nums[N / 2];
		if (ans == INF)
			ans = nums[N / 2 - 1]; // 마지막이 괄호로 묶여있을 경우 결과 갱신

		nums = copy.clone();
		return ans;
	}

	static int cal(int a, int b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return Integer.MIN_VALUE;
	}

}
