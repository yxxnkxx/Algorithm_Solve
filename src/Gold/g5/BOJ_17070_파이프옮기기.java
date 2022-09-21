package Gold.g5;

import java.util.Scanner;

public class BOJ_17070_파이프옮기기 {
	static int[][] map;
	static int[][] dr = { { 0, 1 }, { 1, 1 }, { 1, 1, 0 } };
	static int[][] dc = { { 1, 1 }, { 0, 1 }, { 1, 0, 1 } }; // 가로 세로 대각선 이동 위치
	static int N;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		dfs(0, 1, 0);
		System.out.println(cnt);
	}

	static void dfs(int r, int c, int dir) {
		// 0은 가로, 1은 세로 , 2는 대각선
		if (r == N - 1 && c == N - 1) {
			cnt++;
			return;
		}

		for (int i = 0; i < dr[dir].length; i++) {
			int nr = r + dr[dir][i];
			int nc = c + dc[dir][i];
			if (nr < N && nc < N) {
				// 대각선
				if (dr[dir][i] == 1 && dc[dir][i] == 1) {
					if (map[nr][nc] == 0 && map[nr - 1][nc] == 0 && map[nr][nc - 1] == 0) {
						dfs(nr, nc, 2);
					}
				}

				// 가로 세로
				else if (map[nr][nc] == 0) {
					if (dr[dir][i] == 1)
						dfs(nr, nc, 1);
					// 가로
					else
						dfs(nr, nc, 0);
					// 세로
				}

			}
		}
	}
}
