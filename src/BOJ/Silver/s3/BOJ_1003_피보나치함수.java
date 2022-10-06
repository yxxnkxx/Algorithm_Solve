package BOJ.Silver.s3;

import java.util.Scanner;

public class BOJ_1003_피보나치함수 {
	public static void main(String[] args) {
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int i = sc.nextInt();
			sb.append(dp[i][0]);
			sb.append(" ");
			sb.append(dp[i][1]).append("\n");

		}

		System.out.print(sb);
	}

}
