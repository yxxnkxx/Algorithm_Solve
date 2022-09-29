package BOJ.Silver.s1;

import java.util.Scanner;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		dp[0][1] = arr[0];

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);

			// i=1인 경우, i-1을 빼는 경우 / i-1, i-2를 모두 빼는 경우
			if (i == 1)
				dp[i][1] = dp[i - 1][0] + arr[i];
			else
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + arr[i];

			dp[i][2] = dp[i - 1][1] + arr[i];

		}

		int ans = Math.max(dp[N - 1][0], dp[N - 1][1]);
		ans = Math.max(ans, dp[N - 1][2]);
		System.out.println(ans);
	}

}
