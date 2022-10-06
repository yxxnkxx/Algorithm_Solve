package BOJ.Silver.s3;

import java.util.Scanner;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) {
		int[] dp = new int[11]; // 입력 범위 1~10
		dp[0] = 1;
		// 1로 구하기
		for (int n = 1; n <= 10; n++) {
			for (int i = 1; i <= 3; i++)
				if (n - i >= 0)
					dp[n] += dp[n - i];
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++)
			System.out.println(dp[sc.nextInt()]);

	}

}
