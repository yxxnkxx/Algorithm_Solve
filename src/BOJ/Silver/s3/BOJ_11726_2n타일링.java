package BOJ.Silver.s3;

import java.util.Scanner;

public class BOJ_11726_2n타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[0] = 1;
		for (int i = 2; i <= N; i++)
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		System.out.println(dp[N]);
	}
}
