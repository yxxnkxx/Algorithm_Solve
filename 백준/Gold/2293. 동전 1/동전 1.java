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
		dp[0] = 1;
		for (int n = 0; n < N; n++)
			for (int i = nums[n]; i <= K; i++) {
				dp[i] += dp[i - nums[n]];
			}

		System.out.println(dp[K]);

	}

}