package SWEA.d4;

import java.util.HashSet;
import java.util.Scanner;

public class SWEA_2819_격자판숫자 {

	static HashSet<String> set = new HashSet<>();
	static int cnt;
	static int N = 4;
	static int[] ans = new int[7];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] arr = new int[4][4];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					arr[i][j] = sc.nextInt();

			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					ans[0] = arr[i][j];
					dfs(arr, i, j, 1);
				}

			System.out.println("#" + t + " " + set.size());
			set.clear();
		}
	}

	static void dfs(int[][] arr, int r, int c, int depth) {
		if (depth == 7) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 7; i++)
				sb.append(ans[i]);
			set.add(sb.toString());
			return;
		}

		// 사방탐색
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
				ans[depth] = arr[nr][nc];
				dfs(arr, nr, nc, depth + 1);
			}
		}

	}

}
