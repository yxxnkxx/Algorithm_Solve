package Silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2667_단지번호붙이기 {
	static char[][] map;
	static int N;
	static boolean[][] visited;
	static List<Integer> house;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		house = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int idx = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					house.add(0);
					dfs(i, j, idx++);
				}
			}
		System.out.println(idx);
		Collections.sort(house);
		for (int num : house) {
			System.out.println(num);
		}

	}

	static void dfs(int i, int j, int idx) {
		visited[i][j] = true;
		house.set(idx, house.get(idx) + 1); // cnt 1 더해주기

		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '1' && !visited[nr][nc]) {
				dfs(nr, nc, idx);
			}
		}

	}
}
