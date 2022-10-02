import java.util.Scanner;

public class Main {

	static int[] dr = { 1, -1, 0, 0 }; // 아래 위 오 왼
	static int[] dc = { 0, 0, 1, -1 };
	static int N, M;
	static int[][] map;
	static int ans;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();

		// 모두 길이가 4, 각각의 모양을 하나씩 검사하면 됨
		for (int r = 0; r < N; r++)
			for (int c = 0; c < M; c++)
				for (int d = 0; d < 4; d++)
					dfs(r, c, 1, map[r][c], d);

		// bfs 한번만..
		for (int r = 0; r < N; r++)
			for (int c = 0; c < M; c++)
				find(r, c);

		System.out.println(ans);
	}

	static void find(int r, int c) {
		/*
		 * 1 3 모양 검사하기..
		 */
		int[] nr = { r + 1, r - 1, r, r };
		int[] nc = { c, c, c + 1, c - 1 };
		label: for (int i = 0; i < 4; i++) {
			int sum = map[r][c];
			for (int j = 0; j < 4; j++) {
				// 하나라도 범위 벗어나면 continue
				if (i != j) {
					if (nr[j] < 0 || nr[j] >= N || nc[j] < 0 || nc[j] >= M)
						continue label;
					sum += map[nr[j]][nc[j]];
				}
			}
			ans = Math.max(ans, sum);
		}
	}

	static void dfs(int r, int c, int depth, int sum, int dir) {
		if (depth == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, depth + 1, sum + map[nr][nc], d);
				visited[nr][nc] = false;
			}
		}
		visited[r][c] = false;

	}
}