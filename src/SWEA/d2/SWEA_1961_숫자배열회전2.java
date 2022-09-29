package SWEA.d2;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			StringBuilder[] ans = new StringBuilder[N];
			for (int i = 0; i < N; i++)
				ans[i] = new StringBuilder(); // 정답을 담을 sb

			// 90도
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--)
					ans[j].append(arr[i][j]); // j고정, i는 N-1~0
				ans[j].append(" ");
			}

			// 180도
			// i 고정, i는 N~0, j는 N~0
			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					ans[N - 1 - i].append(arr[i][j]); // i가 거꾸로니까 N-1-i에 담아야함
				}
				ans[N - 1 - i].append(" ");
			}

			// 270도
			// j 고정, j는 N~0, i는 0~N
			for (int j = N - 1; j >= 0; j--) {
				for (int i = 0; i < N; i++)
					ans[N - 1 - j].append(arr[i][j]);
				ans[N - 1 - j].append(" ");
			}

			System.out.println("#" + (t + 1));
			for (StringBuilder answer : ans) {
				System.out.println(answer);
			}
		} // tc
	}

}
