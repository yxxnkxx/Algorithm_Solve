
import java.util.Scanner;

public class Main {
	static int[] op;
	static long[] nums;
	static int[] visited;
	static int N;
	static long max;
	static long min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new long[N];
		for (int i = 0; i < N; i++)
			nums[i] = sc.nextLong();
		op = new int[4];
		visited = new int[4];
		for (int i = 0; i < 4; i++)
			op[i] = sc.nextInt();
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		dfs(0, nums[0]);
		System.out.println(max);
		System.out.println(min);

	}

	static void dfs(int depth, long num1) {
		if (depth == N - 1) {
			max = Math.max(max, num1);
			min = Math.min(min, num1);
			return;
		}
		long num2 = nums[depth + 1];

		for (int i = 0; i < 4; i++) {
			if (op[i] != visited[i]) {
				visited[i] += 1;
				dfs(depth + 1, cal(i, num1, num2));
				visited[i] -= 1;
			}
		}

	}

	static long cal(int op, long num1, long num2) {
		switch (op) {
		case 0:
			return num1 + num2;
		case 1:
			return num1 - num2;
		case 2:
			return num1 * num2;
		case 3:
			return num1 / num2;

		}
		return (Long) null;
	}
}
