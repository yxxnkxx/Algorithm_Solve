package SWEA.d3;

import java.util.Scanner;

public class SWEA_2817_부분수열의합 {
	static int N, K;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			findSum(0, 0);
			if (K == 0)
				cnt--;
			System.out.println("#" + t + " " + cnt);
			cnt = 0;
		}
	}

	static void findSum(int i, int sum) {
		if (i == N) {
			if (K == sum)
				cnt++;
			return;
		}

		findSum(i + 1, sum + arr[i]);
		findSum(i + 1, sum);
	}
}
