package Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4803_트리 {
	static int N, M;
	static boolean visited[];
	static int[][] edges;
	static int cnt;
	static boolean cycle;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		edges = new int[501][501];
		int tc = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0)
				break; // 0 종료 조건

			cycle = false;
			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(edges[i], 0);
			} // 순환할 때마다 edge 초기화

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				edges[start][end] = 1;
				edges[end][start] = 1;
			} // 입력

			cnt = 0; // tree의 개수
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					cnt++;
					visited[i] = true;
					cycle = false;
					dfs(i, i);
					if (cycle)
						cnt--; // cycle이면 tree x
				}
			}
			sb.append("Case " + (tc++) + ": ");
			if (cnt == 0)
				sb.append("No trees.\n"); // 대문자로 잘못 씀.......................
			else if (cnt == 1)
				sb.append("There is one tree.\n");
			else
				sb.append("A forest of " + cnt + " trees.\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int pre, int v) {
		for (int i = 1; i <= 500; i++) {
			if (edges[v][i] == 1) {
				if (visited[i] && i != pre || (v == i)) { // v==i인 경우는 1 1처럼 자기 자신으로 향하는 경우, i가 방문되었으나 이전 노드(부모 노드)가 아닌
															// 경우에는 cycle임
					cycle = true;
				}
				if (!visited[i]) {
					visited[i] = true;
					dfs(v, i);
				}
			}

		}
	}

}