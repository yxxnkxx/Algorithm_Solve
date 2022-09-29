package BOJ.Silver.s4;

import java.util.Scanner;

public class BOJ_10157_자리배정_ver2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); // col
		int R = sc.nextInt(); // row
		int K = sc.nextInt();
		int[][] arr = new int[R + 1][C + 1];

		int cnt = 0;
		int dir = 0;
		int r = 0;
		int c = 1;
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		if (K > C * R)
			System.out.println(0);
		else {
			while (cnt <= K) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr <= 0 || nr > R || nc <= 0 || nc > C || arr[nr][nc] != 0) {
					dir = (dir + 1) % 4;
					continue;
				}
				arr[nr][nc] = ++cnt;
				r = nr;
				c = nc;

				if (cnt == K) {
					System.out.println(nc + " " + nr);
					break;
				}

			}
		}

	}
}
