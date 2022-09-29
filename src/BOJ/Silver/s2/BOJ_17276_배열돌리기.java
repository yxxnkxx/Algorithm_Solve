package BOJ.Silver.s2;

import java.util.Scanner;

public class BOJ_17276_배열돌리기 {
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 왼쪽 위부터 시계방향으로 회전
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt(); // 크기
			int d = sc.nextInt(); // 각도
			arr = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			if (d < 0)
				d += 360; // 시계방향으로 통일
			d /= 45; // 45로 나눈 몫만큼 회전함
			int mid = N / 2;
			for (int i = 1; i <= mid; i++) {
				for (int repeat = 0; repeat < d; repeat++)
					swap(mid, mid, i);
			}
			for (int r = 0; r < N; r++) {
				for (int j = 0; j < N; j++)
					sb.append(arr[r][j] + " ");
				sb.append("\n");
			}
		} // tc
		System.out.print(sb.toString());
	}

	static void swap(int r, int c, int d) {
		int tmp = arr[r + dr[7] * d][c + dc[7] * d];
		for (int i = 7; i > 0; i--) {
			arr[r + dr[i] * d][c + dc[i] * d] = arr[r + dr[i - 1] * d][c + dc[i - 1] * d];
		}
		arr[r + dr[0] * d][c + dc[0] * d] = tmp;
		// 8방을 회전하기

	}

}
