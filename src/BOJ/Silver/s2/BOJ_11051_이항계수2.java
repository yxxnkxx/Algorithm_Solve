package BOJ.Silver.s2;

import java.util.Scanner;

public class BOJ_11051_이항계수2 {
	static int[][] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		memo = new int[N + 1][K + 1];
		System.out.println(bino(N, K) % 10007);

	}

	static int bino(int N, int K) {

		if (N < K)
			return 0;

		if (memo[N][K] > 0)
			return memo[N][K];

		if (K == 0 || N == K) {
			memo[N][K] = 1;
			return memo[N][K];
		}

		memo[N][K] = bino(N - 1, K) % 10007 + bino(N - 1, K - 1) % 10007;
		return memo[N][K];
	}

}
