package Silver.s3;

import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	static int N;
	static int[] stairs;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stairs = new int[N];
		dp = new int[N][2]; // [i][1]에는 몇개 연속인지

		for (int i = 0; i < N; i++)
			stairs[i] = sc.nextInt();

		dp[0][0] = stairs[0];

		for (int i = 1; i < N - 1; i++)
			find(i);

		// 마지막 계단은 무조건 밟아야함
		if (dp[N - 2][1] == 1) {
			dp[N - 1][0] = Math.max(dp[N - 2][0] - stairs[N - 2], dp[N - 2][0] - stairs[N - 3]) + stairs[N - 1];
		} else {
			dp[N - 1][0] = Math.max(dp[N - 2][0], dp[N - 3][0]) + stairs[N - 1]; // 둘 중 큰거
		}

		System.out.println(dp[N - 1][0]);

	}

	static void find(int stair) {

		if (stair == 1) {
			dp[1][0] = stairs[1] + stairs[0];
			dp[1][1] = 1;
			return;
		}

		else if (dp[stair - 1][1] == 1) // 연속 불가능
		{
			dp[stair][0] = Math.max(dp[stair - 1][0] - stairs[stair - 1], dp[stair - 2][0]) + stairs[stair]; // n-1 포함x,

			dp[stair][0] = Math.max(dp[stair][0], dp[stair - 1][0]); // n을 포함x

		} else {
			if (dp[stair - 1][0] > dp[stair - 2][0]) {
				dp[stair][0] = dp[stair - 1][0] + stairs[stair];
				dp[stair][1] = dp[stair - 1][1] + 1;
			} else
				dp[stair][0] = dp[stair - 2][0] + stairs[stair];

		}

	}

}
