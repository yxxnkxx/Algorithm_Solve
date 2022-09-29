package BOJ.Silver.s2;

import java.util.Scanner;

public class BOJ_2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int white;
	static int blue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		dc(N, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

	static void dc(int N, int r, int c) {
		if (N == 1) {
			if (map[r][c] == 1)
				blue++;
			else
				white++;
			return;
		}
		boolean check = true;
		int color = map[r][c];
		label: for (int i = r; i < r + N; i++)
			for (int j = c; j < c + N; j++) {
				if (map[i][j] != color) {
					check = false;
					break label;
				}
			}

		if (check) {
			if (color == 0)
				white++;
			else if (color == 1)
				blue++;
			return;
		}
		dc(N / 2, r, c);
		dc(N / 2, r + N / 2, c);
		dc(N / 2, r, c + N / 2);
		dc(N / 2, r + N / 2, c + N / 2);

	}
}
