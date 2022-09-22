package Gold.g5;

import java.util.Scanner;

public class BOJ_12865_평범한배낭 {
	static int N, K;
	static int[] value;
	static int[] weight;
	static int[][] dp; // 0에 weight, 1에 value 저장
	static int ans = 0;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		value = new int[N + 1];
		weight = new int[N + 1];
		visited = new boolean[N];
		dp = new int[N + 1][K + 1]; // row는 N, col은 K(무게)

		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		for (int n = 1; n <= N; n++) {
			// n번째 값에 대해 dp값 구하기
			for (int w = 1; w <= K; w++)
				if (weight[n] <= w) { // 물건 추가 가능
					dp[n][w] = Math.max(value[n] + dp[n - 1][w - weight[n]], dp[n - 1][w]);

				} else // 물건 추가 불가능
					dp[n][w] = dp[n - 1][w];

		}
		System.out.println(dp[N][K]);

	}

}
