package Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069_파이프옮기기2 {
	static int N;
	static long[][][] dp; // int로 하면 N이 커졌을 때 답 틀림
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N][N][3];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		} // 입력

		// 0 가로 1 세로 2 대각선
		dp[0][1][0] = 1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				find(i, j);
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}

	static void find(int r, int c) {
		// 0,0 은 return
		if (r == 0 && c == 0)
			return;

		// 가로 검사
		if (c - 1 >= 0 && map[r][c] == 0) {
			dp[r][c][0] += dp[r][c - 1][0];
			dp[r][c][0] += dp[r][c - 1][2];
		}

		// 세로 검사
		if (r - 1 >= 0 && map[r][c] == 0) {
			dp[r][c][1] += dp[r - 1][c][1];
			dp[r][c][1] += dp[r - 1][c][2];
		}
		// 대각선 검사
		if (r - 1 >= 0 && c - 1 >= 0 && map[r][c] == 0 && map[r - 1][c] == 0 && map[r][c - 1] == 0) {
			dp[r][c][2] += dp[r - 1][c - 1][0];
			dp[r][c][2] += dp[r - 1][c - 1][1];
			dp[r][c][2] += dp[r - 1][c - 1][2];
		}

	}

}
