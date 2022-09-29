package SWEA.d2;

import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) {
		int size = 9;
		int[][] sudoku = new int[size][size];
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		label: for (int t = 0; t < T; t++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 가로 체크
			for (int i = 0; i < size; i++) {
				int[] check = new int[9];
				for (int j = 0; j < size; j++) {
					check[sudoku[i][j] - 1]++;
				}

				for (int num : check) {
					if (num != 1) {
						System.out.println("#" + (t + 1) + " " + 0);
						continue label;
					}
				}
			}

			// 세로 체크
			for (int j = 0; j < size; j++) {
				int[] check = new int[9];
				for (int i = 0; i < size; i++) {
					check[sudoku[i][j] - 1]++;
				}
				for (int num : check) {
					if (num != 1) {
						System.out.println("#" + (t + 1) + " " + 0);
						continue label;
					}
				}
			}

			for (int i = 0; i < size; i += 3) {
				for (int j = 0; j < size; j += 3) {
					int[] check = new int[9];
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							check[sudoku[k][l] - 1]++;
						}
					}

					for (int num : check) {
						if (num != 1) {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}

					}
				}
			}

			System.out.println("#" + (t + 1) + " " + 1);

		}

	}

}
