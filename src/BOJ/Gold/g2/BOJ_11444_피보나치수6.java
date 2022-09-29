package BOJ.Gold.g2;

import java.util.Scanner;

public class BOJ_11444_피보나치수6 {
	static long[][] fibs = new long[][] { { 1, 1 }, { 1, 0 } };
	final static long MOD = 1000000007;

	public static void main(String[] args) {
		/*
		 * 행렬 제곱 이용 Fn = ((1,1),(1,0))의 n 제곱) 분할 정복 이용
		 */
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long[][] result = fib(N);
		System.out.println(result[0][1]);

	}

	static long[][] mulMatrix(long[][] a, long[][] b) {
		long[][] tmp = new long[2][2];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++) {
				for (int d = 0; d < 2; d++)
					tmp[i][j] = (tmp[i][j] + a[i][d] * b[d][j]) % MOD;
			}
		return tmp;
	}

	static long[][] fib(long n) {
		if (n == 1) {
			return fibs;
		}

		long[][] tmp = fib(n / 2);
		if (n % 2 == 0)
			return mulMatrix(tmp, tmp);
		else
			return mulMatrix(mulMatrix(tmp, tmp), fibs);

	}
}
