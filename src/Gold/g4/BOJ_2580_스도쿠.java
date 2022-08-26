package Gold.g4;

import java.util.Scanner;

public class BOJ_2580_스도쿠 {

	static int[][] sudoku = new int[9][9];
	static int[][] memo = new int[81][3]; // row col 값
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				sudoku[i][j] = sc.nextInt();
		// 입력

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (sudoku[i][j] == 0) {
					find(i, j, 1);
				}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(sudoku[i][j] + " ");
			System.out.println();
		}
	}

	static void find(int row, int col, int start) {
		boolean possible = false;
		out: for (int i = start; i < 9; i++) {

			for (int d = 0; d < 9; d++) {
				if (sudoku[d][col] == i)
					continue out;
				if (sudoku[row][d] == i)
					continue out;
			}
			int r3 = row / 3 * 3;
			int c3 = col / 3 * 3;
			for (int r = r3; r <= r3 + 2; r++)
				for (int c = c3; c <= c3 + 2; c++)
					if (sudoku[r][c] == i)
						continue out;
			possible = true;
			sudoku[row][col] = i;
			memo[cnt++] = new int[] { row, col, i };
			break;
		}

		if (!possible) {
			cnt--;
			sudoku[memo[cnt][0]][memo[cnt][1]] = 0; // 백트래킹
			find(memo[cnt][0], memo[cnt][1], memo[cnt][2] + 1);
		}
	}

}
