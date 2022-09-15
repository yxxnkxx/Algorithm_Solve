package Silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int N;
	static int[][] matrix;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		matrix = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			matrix[s][e] = 1;
			matrix[e][s] = 1;
		}

		dfs(1);
		System.out.println(cnt);

	}

	static void dfs(int i) {
		visited[i] = true;
		for (int j = 1; j <= N; j++) {
			if (matrix[i][j] == 1 && !visited[j]) {
				cnt++;
				dfs(j);
			}
		}
	}

	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();

		q.add(i);
		visited[i] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int j = 1; j <= N; j++) {
				if (matrix[temp][j] == 1 && !visited[j]) {
					cnt++;
					visited[j] = true;
					q.offer(j);
				}
			}
		}
	}
}
