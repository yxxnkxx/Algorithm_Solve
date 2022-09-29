package BOJ.Silver.s2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4963_섬의개수 {
	static boolean[][] visited;
	static int[][] map;
	static int W, H;
	static int cnt;
	static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			W = sc.nextInt(); // col
			H = sc.nextInt(); // row
			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			visited = new boolean[H][W];
			cnt = 0;
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();

			for (int r = 0; r < H; r++)
				for (int c = 0; c < W; c++)
					if (map[r][c] == 1 && !visited[r][c]) {
						cnt++;
//						dfs(r, c);
						bfs(r, c);
					}
			sb.append(cnt).append("\n");

		}

		System.out.print(sb);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		// 팔방탐색을 해서 갈 곳이 있으면 감
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 1 && !visited[nr][nc])
				dfs(nr, nc);
		}

	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int row = tmp[0];
			int col = tmp[1];
			for (int d = 0; d < 8; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}

		}

	}

}
