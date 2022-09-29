package SWEA.d2;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	static int[][] nums;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			nums = new int[N][N];
			int cnt = 1;
			int r = 0;
			int c = 0;
			nums[r][c] = cnt;
			int dir = 0;
			while (true) {
				if (cnt >= N * N)
					break;

				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || nums[nr][nc] != 0) {
					dir = (dir + 1) % 4;
					continue;
				}
				nums[nr][nc] = ++cnt;
				r = nr;
				c = nc;
			}

			System.out.println("#" + (t + 1));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(nums[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

}
