package Gold.g4;

import java.util.Scanner;

public class BOJ_2580_스도쿠 {

	static int[][] sudoku = new int[9][9];
	static int N = 0;
	static int[][] memo;
	static int cnt = 0;
	static boolean found = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = sc.nextInt();
				if (sudoku[i][j] == 0) {
					N++;
				}
			}
		// 입력
		memo = new int[N][2]; // i, j의 좌표 담기

		dfs(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(sudoku[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb.toString());

	}

	static boolean find(int i, int j, int start) {

		int r3 = i / 3 * 3;
		int c3 = j / 3 * 3;

		label: for (int k = start; k <= 9; k++) {
			// 가로
			for (int c = 0; c < 9; c++) {
				if (sudoku[i][c] == k) {
					continue label;
				}
				// 세로
				if (sudoku[c][j] == k) {
					continue label;
				}
			}

			for (int r = r3; r < r3 + 3; r++)
				for (int c = c3; c < c3 + 3; c++)
					if (sudoku[r][c] == k) {
						continue label;
					}
			sudoku[i][j] = k;
			return true;
		}

		return false;
	}

	static void dfs(int depth) {
		if (depth == N) {
			return;
		}

		int i = 0;
		int j = 0;

		out: for (i = 0; i < 9; i++)
			for (j = 0; j < 9; j++)
				if (sudoku[i][j] == 0)
					break out;

		memo[depth] = new int[] { i, j };

		boolean check = find(i, j, 0);

		if (check) {
			dfs(depth + 1);
		} else {
			while (!check) {
				depth--;
				int start = sudoku[memo[depth][0]][memo[depth][1]];
				sudoku[memo[depth][0]][memo[depth][1]] = 0;
				check = find(memo[depth][0], memo[depth][1], start + 1); // 다음거부터 다시 탐색하기...
			}
			dfs(depth + 1);
		}
	}

}