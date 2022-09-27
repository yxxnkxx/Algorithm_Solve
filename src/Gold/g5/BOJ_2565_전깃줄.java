package Gold.g5;

import java.util.Scanner;

public class BOJ_2565_전깃줄 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[501];
		int[] dp = new int[501];
		int max = 0;

		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			arr[A] = B; // 연결된 번호 배열에 저장
			dp[A] = 1;
		}
		for (int i = 1; i <= 500; i++)
			if (dp[i] != 0)
				for (int j = 0; j < i; j++)
					if (dp[j] != 0 && arr[j] < arr[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						max = Math.max(dp[i], max);
					}
		System.out.println(N - max);

	}
}
