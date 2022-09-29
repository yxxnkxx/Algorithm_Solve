package SWEA.d2;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			StringBuilder[] result = new StringBuilder[N];
			for (int i = 0; i < N; i++) {
				result[i] = new StringBuilder();
			}

			// 90도 회전
			for (int c = 0; c < N; c++) {
				for (int r = N - 1; r >= 0; r--) {
					result[c].append(arr[r][c]);
				}
				result[c].append(" ");
			}

			// 180도 회전
			for (int r = N - 1; r >= 0; r--) {
				for (int c = N - 1; c >= 0; c--) {
					result[N - 1 - r].append(arr[r][c]);
				}
				result[N - 1 - r].append(" ");
			}

			// 270도 회전
			for (int c = N - 1; c >= 0; c--) {
				for (int r = 0; r < N; r++) {
					result[N - 1 - c].append(arr[r][c]);
				}

			}

			System.out.println("#" + (t + 1));
			for (StringBuilder sb : result) {
				System.out.println(sb.toString());
			}
		}
	}

}
