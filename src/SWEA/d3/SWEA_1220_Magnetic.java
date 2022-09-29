package SWEA.d3;

import java.util.Scanner;

public class SWEA_1220_Magnetic {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] table = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					table[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;
			int prev = 0;
			for (int c = 0; c < n; c++) {
				for (int r = 0; r < n; r++) {
					if (table[r][c] == 1) {
						prev = 1;
					}
					if (prev == 1 && table[r][c] == 2) {
						cnt++;
						prev = 0;
					}
				}
				prev = 0;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
