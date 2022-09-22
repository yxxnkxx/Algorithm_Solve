package Silver.s3;

import java.util.Scanner;

public class BOJ_9461_파도반수열 {
	static long[] dp;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		dp = new long[101];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		while (T-- > 0) {
			N = sc.nextInt();
			System.out.println(find(N - 1));
		}
	}

	static long find(int N) {
		if (dp[N] != 0)
			return dp[N];

		dp[N] = find(N - 2) + find(N - 3);

		return dp[N];
	}

}
