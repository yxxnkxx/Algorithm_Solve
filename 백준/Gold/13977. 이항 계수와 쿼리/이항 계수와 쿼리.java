
import java.util.Scanner;

public class Main {
	static long[] dp = new long[4000001];
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		dp[0] = 1;
		for (int i = 1; i <= 4000000; i++) {
			dp[i] = (dp[i - 1] * i) % MOD;
		}
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			long A = dp[N] % MOD;
			long B = dp[K] * dp[N - K] % MOD;
			long B2 = pow(B, MOD - 2);
			long ans = A * B2 % MOD;
			sb.append(ans).append("\n");
		}
		System.out.println(sb);

	}

	static long pow(long a, int b) {
		if (b == 1)
			return a % MOD;
		long tmp = pow(a, b / 2);
		if (b % 2 == 0)
			return (tmp * tmp) % MOD;
		else
			return (tmp * tmp % MOD * a) % MOD;
	}
}
