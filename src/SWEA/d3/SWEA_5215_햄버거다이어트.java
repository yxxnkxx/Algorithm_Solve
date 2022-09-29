package SWEA.d3;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {

	static int[][] info;
	static int N;
	static int L;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			info = new int[N][2]; // 0에는 점수 1에는 칼로리
			for (int i = 0; i < N; i++)
				info[i] = new int[] { sc.nextInt(), sc.nextInt() };
			findBest(0, 0, 0);
			System.out.println("#" + t + " " + ans);
			ans = 0;

		}
	}

	static void findBest(int i, int score, int cal) {
		if (i == N) {
			if (cal <= L && score > ans)
				ans = score;
			return;
		}
		findBest(i + 1, score + info[i][0], cal + info[i][1]); // 더하기
		findBest(i + 1, score, cal); // 안 더하기
	}

}
