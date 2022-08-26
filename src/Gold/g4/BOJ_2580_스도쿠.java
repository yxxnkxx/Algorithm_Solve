package Gold.g4;

import java.util.Scanner;

public class BOJ_2580_스도쿠 {

	static int[][] sudoku = new int[9][9];
	static int[][] memo = new int[81][3]; // row col 값

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

	}

	static void find(int row, int col, int start) {
		boolean possible = false;
		for (int i = start; i < 9; i++) {

			for (int d = 0; d < 9; d++) {
				if (sudoku[d][col] == i)
					break;
				if (sudoku[row][d] == i)
					break;
			}
			int r3 = row / 3 * 3;
			int c3 = col / 3 * 3;
			out: for (int r = r3; r <= r3 + 2; r++)
				for (int c = c3; c <= c3 + 2; c++)
					if (sudoku[r][c] == i)
						break out;
			possible = true;
			sudoku[row][col] = i;
			break;
		}
	}

}
