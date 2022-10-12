
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] dp;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];
		dp = new int[N + 1][M + 1];
		for (int j = 1; j <= M; j++) {
			dp[0][j] = -3276800;
		}
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j];
				for (int k = 1; k <= i; k++) {
					if (k >= 2)
						dp[i][j] = Math.max(dp[i][j], dp[k - 2][j - 1] + arr[i] - arr[k - 1]);
					else if (k == 1 && j == 1)
						dp[i][j] = Math.max(dp[i][j], arr[i]);
				}
			}
		}
		System.out.println(dp[N][M]);
	}

}
