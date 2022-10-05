import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = sc.nextInt();

		int[] dp = new int[K + 1];
		Arrays.fill(dp, 100001);
		dp[0] = 0;

		for (int n = 0; n < N; n++)
			for (int i = nums[n]; i <= K; i++) {
				dp[i] = Math.min(dp[i - nums[n]] + 1, dp[i]);
			}

		if (dp[K] == 100001)
			System.out.println(-1);
		else
			System.out.println(dp[K]);

	}

}