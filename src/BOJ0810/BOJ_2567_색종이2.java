package BOJ0810;

import java.util.Scanner;

public class BOJ_2567_색종이2 {
	static int[][] arr = new int[100][100];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int col = sc.nextInt();
			int row = sc.nextInt();
			for (int r = row; r < row + 10; r++) {
				for (int c = col; c < col + 10; c++) {
					if (arr[r][c] == 0)
						arr[r][c] = 1;
				}
			}
		}
		int sum = 0;
		for (int r = 0; r < 100; r++)
			for (int c = 0; c < 100; c++) {
				if (arr[r][c] == 1)
					sum += isEdge(r, c);
			}
		System.out.println(sum);
	}

	static int isEdge(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100 || arr[nr][nc] == 0) {
				cnt++;
			}
		}

		return cnt;

	}

}
