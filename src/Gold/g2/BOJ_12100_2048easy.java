package Gold.g2;

import java.util.Scanner;

public class BOJ_12100_2048easy {
	static int N;
	static int max = 0;
	static int[][] copy;
	static int[][] arr;
	static boolean isMove = false;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		copy = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		max = 0;
		dfs(0);

		System.out.println(max);
	}

	static void dfs(int cnt) {
		if (cnt == 5) {
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (arr[i][j] != 0)
						max = Math.max(max, arr[i][j]);
			return;
		}
		int copy[][] = new int[N][N];
		for (int i = 0; i < N; i++)
			copy[i] = arr[i].clone();

		for (int i = 0; i < 4; i++) {
			move(i);
			dfs(cnt + 1);
			for (int a = 0; a < N; a++)
				arr[a] = copy[a].clone();
		}

	}

	static void move(int dir) {
		switch (dir) {
		case 0:
			// 아래 -> 밑에서부터 검사함
			// 0이 아닐 때까지 땡기기
			for (int c = 0; c < N; c++) {
				for (int r = N - 1; r >= 0; r--) {
					if (arr[r][c] == 0) {
						for (int d = r - 1; d >= 0; d--) {
							if (arr[d][c] != 0) {
								arr[r][c] = arr[d][c];
								arr[d][c] = 0;
								break;
							}
						}
					} // 0 땡기기

				}
				for (int r = N - 1; r >= 1; r--) {
					if (arr[r][c] == arr[r - 1][c] && arr[r][c] != 0) {
						arr[r][c] *= 2;
						for (int d = r - 1; d >= 1; d--) {
							arr[d][c] = arr[d - 1][c];
						}
						arr[0][c] = 0;
					}
				}

			}

			break;
		case 1:
			// 위
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					if (arr[r][c] == 0) {
						for (int d = r + 1; d < N; d++) {
							if (arr[d][c] != 0) {
								arr[r][c] = arr[d][c];
								arr[d][c] = 0;
								break;
							}
						}
					} // 0 땡기기

				}
				for (int r = 0; r < N - 1; r++) {
					if (arr[r][c] == arr[r + 1][c] && arr[r][c] != 0) {
						arr[r][c] *= 2;
						for (int d = r + 1; d < N - 1; d++) {
							arr[d][c] = arr[d + 1][c];
						}
						arr[N - 1][c] = 0;
					}
				}

			}

			break;
		case 2:
			// 오
			for (int r = 0; r < N; r++) {
				for (int c = N - 1; c >= 0; c--) {
					if (arr[r][c] == 0) {
						for (int d = c - 1; d >= 0; d--) {
							if (arr[r][d] != 0) {
								arr[r][c] = arr[r][d];
								arr[r][d] = 0;
								break;
							}
						}
					} // 0 땡기기

				}
				for (int c = N - 1; c >= 1; c--) {
					if (arr[r][c] == arr[r][c - 1] && arr[r][c] != 0) {
						arr[r][c] *= 2;
						for (int d = c - 1; d >= 1; d--) {
							arr[r][d] = arr[r][d - 1];
						}
						arr[r][0] = 0;
					}
				}

			}

			break;
		case 3:
			// 왼
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 0) {
						for (int d = c + 1; d < N; d++) {
							if (arr[r][d] != 0) {
								arr[r][c] = arr[r][d];
								arr[r][d] = 0;
								break;
							}
						}
					} // 0 땡기기

				}
				for (int c = 0; c < N - 1; c++) {
					if (arr[r][c] == arr[r][c + 1] && arr[r][c] != 0) {
						arr[r][c] *= 2;
						for (int d = c + 1; d < N - 1; d++) {
							arr[r][d] = arr[r][d + 1];
						}
						arr[r][N - 1] = 0;
					}
				}
			}
			break;
		}

	}
}
