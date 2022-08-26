package Silver.s5;

import java.util.Scanner;

public class BOJ_1010_다리놓기 {
	static long[][] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// nCm의 경우의 수 구하기
			// factorial 활용
			memo = new long[M + 1][N + 1];
			long result = bino(M, N);
			System.out.println(result);

		}
	}

	static long bino(int M, int N) {

		if (memo[M][N] > 0)
			return memo[M][N];

		if (M < N)
			return 0;

		if (N == 0 || M == N) {
			memo[M][N] = 1;
			return 1;
		}
		memo[M][N] = bino(M - 1, N) + bino(M - 1, N - 1);
		return memo[M][N];

	}
}
