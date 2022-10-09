package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동 {

	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static final int INF = Integer.MAX_VALUE;
	static int ans = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		bfs(0, 0);
		if (ans == INF)
			ans = -1;
		System.out.println(ans);
	}

	static void bfs(int r, int c) {
		// 주의: 방문 처리를 3차원 배열에 할 것
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, 0, 1 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == N - 1 && tmp[1] == M - 1) {
				ans = Math.min(tmp[3], ans);
				break;
			}
			if (visited[tmp[0]][tmp[1]][tmp[2]])
				continue;
			visited[tmp[0]][tmp[1]][tmp[2]] = true;
			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == '1' && tmp[2] == 0) {
						q.add(new int[] { nr, nc, 1, tmp[3] + 1 });
					}
					if (map[nr][nc] == '0') {
						q.add(new int[] { nr, nc, tmp[2], tmp[3] + 1 });
					}

				}

			}
		}

	}
}
