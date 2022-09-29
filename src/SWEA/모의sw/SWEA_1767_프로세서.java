package SWEA.모의sw;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1767_프로세서 {
	static int N;
	static int[][] arr;
	static ArrayList<int[]> cores;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;
	static boolean[] check;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			cores = new ArrayList<int[]>();

			ans = Integer.MAX_VALUE; // 코어의 개수
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1)
						cores.add(new int[] { i, j });
				}
			// 입력 끝

			R = cores.size(); // 조합 활용
			check = new boolean[R];
			for (int i = R; i >= 0; i--) {
				comb(0, 0, i);
				if (ans != Integer.MAX_VALUE)
					break; // 갱신되었으면 최대값
			}

			System.out.println("#" + t + " " + ans);

		}

	}

	static void comb(int idx, int cnt, int r) {
		// r개를 뽑는 조합

		if (cnt == r) {
			connect(0, 0);
		}

		for (int i = idx; i < R; i++) {
			check[idx] = true;
			comb(i + 1, cnt + 1, r);
			check[idx] = false;
		}

	}

	static void connect(int idx, int line) {
		if (idx == cores.size()) {
			ans = Math.min(ans, line);
			return;
		}
		if (!check[idx])
			connect(idx + 1, line); // 부분집합에 포함되는 애들만 뽑기

		int R = cores.get(idx)[0];
		int C = cores.get(idx)[1]; // core의 좌표

		// 원래 배열 복사하기

		int[][] tmp = new int[N][2];
		for (int i = 0; i < N; i++) {
			tmp[i][0] = arr[R][i];
			tmp[i][1] = arr[i][C];
		}

		for (int d = 0; d < 4; d++) {
			int nr = R + dr[d];
			int nc = C + dc[d];
			while (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
				nr += dr[d];
				nc += dc[d];
			}
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				// 연결됨
				nr -= dr[d];
				nc -= dc[d];
				int dis = Math.abs(R - nr) + Math.abs(C - nc);
				// 배열 채우기
				while (nr != R || nc != C) {
					arr[nr][nc] = 2;
					nr -= dr[d];
					nc -= dc[d];
				}

				connect(idx + 1, line + dis);
				// 배열 원상복구하기
				for (int t = 0; t < N; t++) {
					arr[R][t] = tmp[t][0];
					arr[t][C] = tmp[t][1];
				}
			}

		}

	}
}