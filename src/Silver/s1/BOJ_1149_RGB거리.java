package Silver.s1;

import java.util.Scanner;

public class BOJ_1149_RGB거리 {
	static int N;
	static int[][] color;
	static int[] dp;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		color = new int[N][3];
		dp = new int[N];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < 3; j++)
				color[i][j] = sc.nextInt();

		for (int i = 0; i < 3; i++) {
			dp[0] = color[0][i];
			find(0, i);
		}
		System.out.println(ans);
	}

	static void find(int idx, int c) {
		if (idx == N) {
			if (dp[idx - 1] < ans)
				ans = dp[idx - 1];
			return;
		}
		// 최소값 확인
		if (idx != 0)
			dp[idx] = dp[idx - 1] + color[idx][c];

		if (dp[idx] < ans)
			for (int i = 0; i < 3; i++)
				if (i != c)
					find(idx + 1, i);
	}
}
