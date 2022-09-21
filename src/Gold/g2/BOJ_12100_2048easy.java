package Gold.g2;

import java.util.Scanner;

public class BOJ_12100_2048easy {
	static int N;
	static int max = 0;
	static boolean isMove = false;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				max = Math.max(arr[i][j], max);
			}
		dfs(0, arr);

		System.out.println(max);
	}

	static void dfs(int cnt, int[][] arr) {
		if (cnt == 5) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			isMove = false;
			int[][] tmp = move(i, arr);

			dfs(cnt + 1, tmp);

		}
	}

	static int[][] move(int dir, int[][] arr) {
		// 일단 0이 있으면 다 없애기~
		switch (dir) {
		case 0:
			// 아래
			for (int r = N - 1; r >= 0; r--)
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 0) {
						for (int d = r - 1; d >= 0; d--) {
							if (arr[d][c] != 0) {
								int m = r - d;
								for (int i = r; i >= m; i--) {
									arr[i][c] = arr[i - m][c];
									arr[i - m][c] = 0;
								}
								break;
							}
						}
					}
				}
			break;
		case 1:
			// 위
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 0) {
						for (int d = r + 1; d < N; d++) {
							if (arr[d][c] != 0) {
								int m = d - r;
								for (int i = r; i < N - m; i++) {
									arr[i][c] = arr[i + m][c];
									arr[i + m][c] = 0;
								}
								break;
							}
						}
					}

				}
			break;

		case 2:
			// 오

			for (int r = 0; r < N; r++)
				for (int c = N - 1; c >= 0; c--) {
					if (arr[r][c] == 0) {
						for (int d = c - 1; d >= 0; d--) {
							if (arr[r][d] != 0) {
								int m = c - d;
								for (int i = c; i >= m; i--) {
									arr[r][i] = arr[r][i - m];
									arr[r][i - m] = 0;
								}
								break;
							}
						}
					}
				}
			break;
		case 3:
			// 왼
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 0) {
						for (int d = c + 1; d < N; d++) {
							if (arr[r][d] != 0) {
								int m = d - c;
								for (int i = c; i < N - m; i++) {
									arr[r][i] = arr[r][i + m];
									arr[r][i + m] = 0;
								}
								break;
							}
						}
					}
				}
			break;
		}

		// 해당 방향에서부터 반대 방향으로 검사
		// ex. 아래면 아래부터 검사해서 같은 게 있으면 합침!
		switch (dir)

		{
		case 0:
			// 아래
			for (int r = N - 1; r >= 1; r--)
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == arr[r - 1][c]) {
						isMove = true;
						arr[r][c] += arr[r][c];
						max = Math.max(max, arr[r][c]);
						// 하나씩 아래로 땡기기

						for (int d = r - 1; d >= 1; d--)
							arr[d][c] = arr[d - 1][c];
						arr[0][c] = 0;
					}
				}
			break;
		case 1:
			// 위
			for (int r = 0; r < N - 1; r++)
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == arr[r + 1][c]) {
						isMove = true;
						arr[r][c] += arr[r][c];
						max = Math.max(max, arr[r][c]);
						// 하나씩 위로 땡기기
						for (int d = r + 1; d < N - 1; d++)
							arr[d][c] = arr[d + 1][c];
						arr[N - 1][c] = 0;
					}
				}
			break;

		case 2:
			// 오

			for (int r = 0; r < N; r++)
				for (int c = N - 1; c >= 1; c--) {
					if (arr[r][c] == arr[r][c - 1]) {
						isMove = true;
						arr[r][c] += arr[r][c];
						max = Math.max(max, arr[r][c]);
						// 하나씩 오른쪽로 땡기기
						for (int d = c - 1; d >= 1; d--)
							arr[r][d] = arr[r][d - 1];
						arr[r][0] = 0;
					}
				}
			break;
		case 3:
			// 왼
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N - 1; c++) {
					if (arr[r][c] == arr[r][c + 1]) {
						isMove = true;
						arr[r][c] += arr[r][c];
						max = Math.max(max, arr[r][c]);
						// 하나씩 위로 땡기기
						for (int d = c + 1; d < N - 1; d++)
							arr[r][d] = arr[r][d + 1];
						arr[r][N - 1] = 0;
					}
				}
			break;
		}

		return arr;

	}
}
