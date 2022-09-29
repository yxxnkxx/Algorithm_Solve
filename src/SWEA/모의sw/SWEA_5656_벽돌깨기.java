package SWEA.모의sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken()); // col
			H = Integer.parseInt(st.nextToken()); // row
			ans = Integer.MAX_VALUE;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			// col에 따라 벽돌깨기 진행
			for (int i = 0; i < W; i++)
				dfs(i, 0);
			if (ans == Integer.MAX_VALUE)
				ans = 0;
			System.out.println("#" + t + " " + ans);
		}
	}

	static void dfs(int i, int depth) {
		if (depth == N) {
			int cnt = 0;
			for (int r = 0; r < H; r++)
				for (int c = 0; c < W; c++)
					if (map[r][c] != 0)
						cnt++;
			ans = Math.min(ans, cnt);
			return;
		}

		for (int r = 0; r < H; r++)
			if (map[r][i] != 0) {
				game(r, i, depth);
				break;
			}

	}

	static void game(int r, int c, int depth) {
		// bfs
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, map[r][c] });

		int[][] copy = new int[H][W];
		for (int i = 0; i < H; i++)
			copy[i] = map[i].clone(); // 원래 배열 저장

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tmpr = tmp[0];
			int tmpc = tmp[1];
			int val = tmp[2];
			map[tmpr][tmpc] = 0;
			label: for (int d = 0; d < 4; d++)
				for (int v = 1; v < val; v++) {
					int nr = tmpr + dr[d] * v;
					int nc = tmpc + dc[d] * v;
					if (nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue label;
					if (map[nr][nc] > 0) { // 1인 경우는 주변에 영향x
						q.add(new int[] { nr, nc, map[nr][nc] });
						map[nr][nc] = 0;
					}
				}

		}

		// 0이 있으면 아래로 당기기
		for (int col = 0; col < W; col++)
			for (int row = H - 1; row >= 0; row--) {
				if (map[row][col] == 0) {
					for (int tmp = row - 1; tmp >= 0; tmp--) {
						if (map[tmp][col] != 0) {
							map[row][col] = map[tmp][col];
							map[tmp][col] = 0;
							break;
						}
					}
				}
			}

		// 다시 dfs
		for (int i = 0; i < W; i++) {
			dfs(i, depth + 1);
		}

		// 배열 원상복구
		for (int i = 0; i < H; i++)
			map[i] = copy[i].clone();

	}

}
