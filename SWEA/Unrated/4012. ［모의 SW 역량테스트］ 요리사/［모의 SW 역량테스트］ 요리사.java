import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] table;
	static int[] comb;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			table = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					table[i][j] = sc.nextInt();

			// 가능한 경우의 수 조합으로 뽑기
			comb = new int[N];
			for (int i = N - 1; i >= N / 2; i--)
				comb[i] = 1; // N/2개 뽑기

			do {
				// 뽑힌 조합의 시너지 합 조회
				find();
			} while (np());

			System.out.println("#" + t + " " + ans);

		}
	}

	static void find() {
		int sum0 = 0;
		int sum1 = 0;

		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++) {
				if (comb[i] == comb[j] && comb[i] == 1) {
					sum0 += table[i][j];
					sum0 += table[j][i];
				}
				if (comb[i] == comb[j] && comb[i] == 0) {
					sum1 += table[i][j];
					sum1 += table[j][i];
				}
			}
		if (Math.abs(sum1 - sum0) < ans)
			ans = Math.abs(sum1 - sum0);

	}

	static boolean np() {
		int a = -1; // 꼭대기
		int c = 0; // a-1보다 큰 수 찾기
		for (int i = 1; i < comb.length; i++) {
			if (comb[i - 1] < comb[i])
				a = i;
		}
		if (a == -1) {
			return false;
		}

		for (int i = comb.length - 1; i >= 0; i--) {
			if (comb[i] > comb[a - 1]) {
				c = i;
				break;
			}
		}
		// a-1과 c를 swap
		int tmp = comb[a - 1];
		comb[a - 1] = comb[c];
		comb[c] = tmp;
		// a부터 끝까지 거꾸로
		Arrays.sort(comb, a, comb.length);
		return true;
	}

}