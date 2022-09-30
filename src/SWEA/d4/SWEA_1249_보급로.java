package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {

	static class Edge implements Comparable<Edge> {
		int r;
		int c;
		int dist;

		public Edge(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}

	}

	static int N;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static int[][] dist;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			// 큰 값으로 초기화
			for (int i = 0; i < N; i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);

			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = str.charAt(j) - '0';
			}
			sb.append("#" + t + " ");
			dijkstra(0, 0);
		}
		System.out.print(sb);

	}

	static void dijkstra(int r, int c) {
		dist[r][c] = 0;
		visited[r][c] = true;
		// 인접 노드:상하좌우
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				pq.add(new Edge(nr, nc, map[nr][nc]));
				dist[nr][nc] = map[nr][nc];
			}
		}

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.r][e.c])
				continue;
			visited[e.r][e.c] = true;
			// e에 인접한 노드들 거리 갱신
			for (int d = 0; d < 4; d++) {
				int nr = e.r + dr[d];
				int nc = e.c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					dist[nr][nc] = Math.min(dist[nr][nc], dist[e.r][e.c] + map[nr][nc]);
					pq.add(new Edge(nr, nc, dist[nr][nc]));
				}
			}

		}
		sb.append(dist[N - 1][N - 1]).append("\n");

	}

}
