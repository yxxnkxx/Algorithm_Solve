import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			ans = 1;
			int maxDay = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, map[i][j]);
				}
			}

			for (int i = 1; i <= maxDay + 1; i++) {
				int cnt = 0;
				visited = new boolean[N][N];
				for (int r = 0; r < N; r++)
					for (int c = 0; c < N; c++) {
						if (map[r][c] > i && !visited[r][c]) {
							cnt++;
							dfs(r, c, i);
						}
						ans = Math.max(cnt, ans);
					}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	static void dfs(int r, int c, int day) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > day && !visited[nr][nc]) {
				dfs(nr, nc, day);
			}
		}
	}
}