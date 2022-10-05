package BOJ.Gold.g5;

import java.util.Scanner;

public class BOJ_2225_합분해 {
	static final long MOD = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		long[][] dp = new long[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}

		for (int i = 1; i <= K; i++)
			dp[0][i] = 1;

		// 점화식 dp[N][K] = dp[N][K-1]+dp[N-1][K-1]+...dp[0][K-1];
		for (int i = 1; i <= N; i++)
			for (int k = 2; k <= K; k++)
				for (int d = 0; d <= i; d++)
					dp[i][k] = (dp[i][k] + dp[d][k - 1]) % MOD;
		System.out.println(dp[N][K]);
	}
}
