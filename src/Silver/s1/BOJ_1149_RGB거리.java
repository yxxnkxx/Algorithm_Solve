package Silver.s1;

import java.util.Scanner;

public class BOJ_1149_RGB거리 {
	static int N;
	static int[][] color;
	static int[][] dp;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		color = new int[N][3];
		dp = new int[N][3];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < 3; j++)
				color[i][j] = sc.nextInt();

		for (int i = 0; i < 3; i++) {
			dp[0][i] = color[0][i];
		}

		for (int i = 0; i < 3; i++)
			find(N - 1, i);
		ans = Math.min(dp[N - 1][0], dp[N - 1][1]);
		ans = Math.min(ans, dp[N - 1][2]);
		System.out.println(ans);
	}

	static int find(int idx, int c) {
		if (dp[idx][c] == 0) {
			switch (c) {
			case 0:
				dp[idx][c] = Math.min(find(idx - 1, 1), find(idx - 1, 2)) + color[idx][c];
				break;
			case 1:
				dp[idx][c] = Math.min(find(idx - 1, 0), find(idx - 1, 2)) + color[idx][c];
				break;
			case 2:
				dp[idx][c] = Math.min(find(idx - 1, 0), find(idx - 1, 1)) + color[idx][c];
				break;
			}
		}
		return dp[idx][c];
	}
}