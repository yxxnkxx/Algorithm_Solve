import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) {
		// dp[n] = max(dp[n-1]) + arr[n]
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j <= i; j++)
				arr[i][j] = sc.nextInt();

		dp[0][0] = arr[0][0];
		int max = 0;
		max = arr[0][0];
		for (int i = 1; i < N; i++)
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					arr[i][j] += arr[i - 1][j];
				else
					arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
				max = Math.max(arr[i][j], max);
			}
		System.out.println(max);
	}

}