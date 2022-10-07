package BOJ.Gold.g4;

import java.util.Scanner;

public class BOJ_17144_미세먼지 {

	static int R, C, T;
	static int[] clean = new int[2]; // 공기 청정기 위치 c=항상 0, clean[0]은 위, clean[1]은 아래
	static int[][] map;
	static int ans;
	static int[] dr0 = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int[] dr1 = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		clean[0] = -1;
		map = new int[R][C];
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					if (clean[0] == -1)
						clean[0] = i;
					else
						clean[1] = i;
				}
			}

		// 확산
		while (T-- > 0) {
			// 확산 값을 저장할 배열
			int[][] tmp = new int[R][C];
			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					if (map[r][c] != 0) {
						int add = map[r][c] / 5;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr0[d];
							int nc = c + dc[d];
							if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
								map[r][c] -= add;
								tmp[nr][nc] += add;
							}
						}
					}
			// 확산 값 더해주기
			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					map[r][c] += tmp[r][c];

			// 정화
			// 순환하기.............
			// 위
			int mover = clean[0] - 1;
			int movec = 0;
			if (mover < 0) {
				mover = 0;
				movec = 1;
			}
			int d = 0;
			while (true) {
				int nr = mover + dr0[d];
				int nc = movec + dc[d];
				if (nr >= 0 && nr <= clean[0] && nc >= 0 && nc < C) {
					if (map[nr][nc] == -1) {
						map[mover][movec] = 0;
						break;
					}
					map[mover][movec] = map[nr][nc];
					mover = nr;
					movec = nc;
				} else {
					d++;
				}

			}

			mover = clean[1] + 1;
			movec = 0;
			if (mover >= R) {
				mover = clean[1];
				movec = 1;
			}
			d = 0;
			while (true) {
				int nr = mover + dr1[d];
				int nc = movec + dc[d];
				if (nr >= clean[1] && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] == -1) {
						map[mover][movec] = 0;
						break;
					}
					map[mover][movec] = map[nr][nc];
					mover = nr;
					movec = nc;
				} else {
					d++;
				}

			}

		}
		int sum = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				sum += map[i][j];
		System.out.println(sum + 2);
	}

}
