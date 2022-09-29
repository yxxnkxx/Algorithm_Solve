package BOJ.Silver.s4;

import java.util.Scanner;

public class BOJ_1018_ColorChess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		String[][] chess = new String[N][M];
		String[][] case1 = new String[N][M]; // W로 시작
		String[][] case2 = new String[N][M]; // B로 시작

		for (int i = 0; i < N; i++) {
			chess[i] = sc.next().split("");
		}

		// case 1
		for (int r = 0; r < 8; r++)
			for (int c = 0; c < 8; c++) {
				if ((r + c) % 2 == 0) {
					case1[r][c] = "W";
					case2[r][c] = "B";
				} else {
					case1[r][c] = "B";
					case2[r][c] = "W";
				}
			}

		// 각각 다른 개수를 출력
		int cnt1 = 0;
		int cnt2 = 0;
		int min = M * N;
		int disr = N - 8;
		int disc = M - 8;

		for (int dr = 0; dr <= disr; dr++) {
			for (int dc = 0; dc <= disc; dc++) {
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						String str = chess[dr + r][dc + c];
						if (!str.equals(case1[r][c])) {
							cnt1++;
						}

						if (!str.equals(case2[r][c])) {
							cnt2++;
						}
					}

				}
				int tmp = Math.min(cnt1, cnt2);
				if (tmp < min)
					min = tmp;
				cnt1 = 0;
				cnt2 = 0;

			}
		}
		System.out.println(min);

	}

}
