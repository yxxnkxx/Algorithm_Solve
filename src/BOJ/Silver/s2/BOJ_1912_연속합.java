package BOJ.Silver.s2;

import java.util.Scanner;

public class BOJ_1912_연속합 {
	static int[] dp;
	static int[] arr;
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		ans = arr[0];
		dp[0] = arr[0];
		// 길이가 2, 3, ... N인 수열 만들기 -> dp 이용
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			ans = Math.max(dp[i], ans);
		}
		System.out.println(ans);
	}
}
