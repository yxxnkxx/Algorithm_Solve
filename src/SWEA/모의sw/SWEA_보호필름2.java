package SWEA.모의sw;

import java.util.Scanner;

public class SWEA_보호필름2 {
	static int D, W, K;
	static int[][] arr;
	static int ans;
	static int[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 0;
			D = sc.nextInt(); // row
			W = sc.nextInt(); // column
			K = sc.nextInt(); // 합격 기준
			arr = new int[D][W];
			check = new int[D];
			for (int d = 0; d < D; d++) {
				check[d] = -1;// 초기화
				for (int w = 0; w < W; w++)
					arr[d][w] = sc.nextInt();
			}

			// 입력
			for (int k = 0; k < K; k++) {
				if (comb(0, 0, k)) {
					ans = k;
					break;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	static boolean comb(int depth, int idx, int r) {
		// depth는 뽑은 수의 개수

		if (depth == r)
			return test();

		if (depth + (D - idx) < r) // 뽑은 수 + 남은 수의 개수 < r이면 r개를 못 뽑음
			return false;

		check[idx] = 0;
		if (comb(depth + 1, idx + 1, r))
			return true;
		check[idx] = 1;
		if (comb(depth + 1, idx + 1, r))
			return true;
		check[idx] = -1;
		if (comb(depth, idx + 1, r))
			return true;
		return false;
	}

	static boolean test() {
		// 성능검사

		for (int w = 0; w < W; w++) {
			int same = 0;
			int a = -1;
			for (int d = 0; d < D && same < K; d++) {

				if (check[d] != -1) {
					if (check[d] == a)
						same++;
					else {
						same = 1;
						a = check[d];
					}
				} else {
					if (arr[d][w] == a)
						same++;
					else {
						same = 1;
						a = arr[d][w];
					}
				}

			}
			if (same < K)
				return false;
		}
		return true;
	}
}
