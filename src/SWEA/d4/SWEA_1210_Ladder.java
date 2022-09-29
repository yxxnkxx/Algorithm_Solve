package SWEA.d4;

import java.util.Scanner;

public class SWEA_1210_Ladder {
	static int[][] ladder = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int T = sc.nextInt();
			int xr = 0;
			int xc = 0;
			for (int i = 0; i < 100; i++)
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if (ladder[i][j] == 2) {
						xr = i;
						xc = j;
					}
				}
			int dir = 3; // dir 확인
			// 1은 왼쪽, 2는 오른쪽, 3은 위
			while (xr > 0) { // xc가 0이 되면 그때 xr 값이 구하려는 값

				if (xc - 1 >= 0 && ladder[xr][xc - 1] == 1 && dir != 2) {
					dir = 1;
					xc--;
				}

				else if (xc + 1 < 100 && ladder[xr][xc + 1] == 1 && dir != 1) {
					dir = 2;
					xc++;
				} else if (ladder[xr - 1][xc] == 1) {
					dir = 3;
					xr--;
				}

			}
			System.out.println("#" + T + " " + xc);
		}
	}

}
