package BOJ.Gold.g1;

import java.util.Scanner;

public class BOJ_11401_이항계수3 {
	static final int MOD = 1000000007;

	public static void main(String[] args) {

		// 페르마의 소정리

		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();

		// A = N!
		long A = 1;
		for (int i = 2; i <= N; i++)
			A = (A * i) % MOD;

		// B = K!*(N-K)!
		long B = 1;
		for (int i = 2; i <= K; i++)
			B = (B * i) % MOD;
		for (int i = 2; i <= N - K; i++)
			B = (B * i) % MOD;
		// B p-2승 구하기
		int p = MOD;
		long b2 = pow(B, p - 2);
		long ans = A * b2 % MOD;
		System.out.println(ans);
	}

	static long pow(long a, int b) {
		if (b == 1)
			return a % MOD;
		long tmp = pow(a, b / 2);
		if (b % 2 == 0)
			return (tmp * tmp) % MOD;
		else
			return (tmp * tmp % MOD * a) % MOD;
	}

}
