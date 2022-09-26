package Silver.s2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11053_LIS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		int[] dp = new int[N];
		Arrays.fill(dp, 1);

		for (int i = 1; i < N; i++)
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i])
					// i번째를 포함할지 안할지
					dp[i] = Math.max(dp[j] + 1, dp[i]);

			}
		int ans = 0;
		for (int i = 0; i < N; i++)
			ans = Math.max(dp[i], ans);
		System.out.println(ans);

	}

}
