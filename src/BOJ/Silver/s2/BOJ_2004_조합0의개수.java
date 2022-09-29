package BOJ.Silver.s2;

import java.util.Scanner;

public class BOJ_2004_조합0의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long M = sc.nextLong();

		long a2 = find2(N);
		long b2 = find2(N - M);
		long c2 = find2(M);

		long a5 = find5(N);
		long b5 = find5(N - M);
		long c5 = find5(M);

		System.out.println(Math.min(a2 - b2 - c2, a5 - b5 - c5));

	}

	static long find2(long N) {
		int cnt = 0;
		while (N >= 2) {
			cnt += N / 2;
			N /= 2;
		}
		return cnt;

	}

	static long find5(long N) {
		int cnt = 0;
		while (N >= 5) {
			cnt += N / 5;
			N /= 5;
		}
		return cnt;

	}

}
