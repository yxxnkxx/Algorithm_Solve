package BOJ.Gold.g1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2098_외판원순회 {
	static int N;
	static int[][] map;
	static int[][] dp;
	static final int INF = 16000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		dp = new int[N][(1 << N) - 1]; // [현재 위치][이미 방문한 도시]
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);
		System.out.println(dfs(0, 1));

	}

	static int dfs(int curr, int visit) {
		if (visit == (1 << N) - 1) {// 모든 도시 방문했다면 해당 위치에서 시작점으로 바로 돌아가는 거리만 구하면 됨
			if (map[curr][0] == 0)
				return INF;
			return map[curr][0];
		}

		if (dp[curr][visit] != -1) // 이미 방문
			return dp[curr][visit];

		dp[curr][visit] = INF;
		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) == 0 && map[curr][i] != 0) {
				// i번째 방문하지 않음 + curr -> i까지 가는 길이 있음
				// 이미 방문한 도시가 visit, 방문하지 않은 나머지 도시들을 방문하고 돌아오는 비용
				dp[curr][visit] = Math.min(dp[curr][visit], dfs(i, visit | (1 << i)) + map[curr][i]);
				// dfs(다음 도시, 다음도시 방문했다고 가정) + 여기서 다음 도시까지의 거리 와 최소거리 비교

			}
		}
		return dp[curr][visit];

	}

}
