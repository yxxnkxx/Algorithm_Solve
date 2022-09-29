package SWEA.d4;

import java.util.Scanner;

/*
 * 부분집합 구하기 -> 작은거부터 큰순서대로 ㄱㄱ
 */

public class SWEA_1486_장훈이의높은선반 {
	static int N;
	static int B;
	static int[] height;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();
			height = new int[N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++)
				height[i] = sc.nextInt();
			powerSet(0, 0);
			System.out.println("#" + t + " " + ans);

		}

	}

	static void powerSet(int idx, int sum) {
		if (idx == N) {
			if (sum >= B)
				ans = Math.min(ans, sum - B);
			return;
		}
		powerSet(idx + 1, sum);
		powerSet(idx + 1, sum + height[idx]);
	}

}
