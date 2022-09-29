package BOJ.Silver.s3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1904_01타일 {
	static long[] memo;

	public static void main(String[] args) {

		// 1 2 3 5 8 13 ... 피보나치 수로 늘어남

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new long[N + 1];
		Arrays.fill(memo, -1);
		memo[0] = 1;
		memo[1] = 1;
		long ans = fib(N);
		System.out.println(ans);
	}

	static long fib(int N) {
		if (memo[N] == -1)
			memo[N] = (fib(N - 1) + fib(N - 2)) % 15746;
		return memo[N];
		// 이클립스에서는 스택오버플로우, 제출하면 괜찮음..흠
	}
}
