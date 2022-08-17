package Silver.s4;

import java.util.Scanner;

public class BOJ_10157_자리배정 {
	static int[][] arr;
	static int C, R, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		arr = new int[C + 1][R + 1];
		int cnt = 0;
		fill(cnt, 1, 1, 1);

	}

	static void fill(int cnt, int c, int r, int dir) {

		if (K > C * R) {
			System.out.println("0");
			return;
		}

		while (cnt <= K) {

			if (c > 0 && c <= C && r > 0 && r <= R && arr[c][r] == 0) {
				arr[c][r] = ++cnt;
			}
			if (cnt == K)
				break;

			switch (dir) {
			case 1:
				if (r + 1 <= R && arr[c][r + 1] == 0) {
					r++;
				} else {
					dir = 2;
				}
				break;
			case 2:
				if (c + 1 <= C && arr[c + 1][r] == 0) {
					c++;
				} else {
					dir = 3;
				}
				break;
			case 3:
				if (r - 1 > 0 && arr[c][r - 1] == 0) {
					r--;
				} else {
					dir = 4;
				}
				break;
			case 4:
				if (c - 1 > 0 && arr[c - 1][r] == 0) {
					c--;
				} else {
					dir = 1;
				}
				break;

			}

		}

		System.out.println(c + " " + r);
		return;

	}
}
