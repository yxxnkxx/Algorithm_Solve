import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] dp = new int[6][2];
		// 앞 3개는 최대, 뒤 3개는 최소
		int i0 = sc.nextInt();
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		dp[0][0] = dp[3][0] = i0;
		dp[1][0] = dp[4][0] = i1;
		dp[2][0] = dp[5][0] = i2;

		for (int i = 0; i < N - 1; i++) {
			int j0 = sc.nextInt();
			int j1 = sc.nextInt();
			int j2 = sc.nextInt();
			dp[0][1] = Math.max(dp[0][0], dp[1][0]) + j0;
			dp[1][1] = Math.max(Math.max(dp[0][0], dp[1][0]), dp[2][0]) + j1;
			dp[2][1] = Math.max(dp[1][0], dp[2][0]) + j2; // max

			// 최소
			dp[3][1] = Math.min(dp[3][0], dp[4][0]) + j0;
			dp[4][1] = Math.min(Math.min(dp[3][0], dp[4][0]), dp[5][0]) + j1;
			dp[5][1] = Math.min(dp[4][0], dp[5][0]) + j2;

			// dp[1]를 dp[0] 값으로 옮기기
			for (int j = 0; j < 6; j++)
				dp[j][0] = dp[j][1];

		}
		// n이 1일때 틀림
		System.out.println(Math.max(Math.max(dp[0][0], dp[1][0]), dp[2][0]) + " "
				+ Math.min(Math.min(dp[3][0], dp[4][0]), dp[5][0]));

	}

}