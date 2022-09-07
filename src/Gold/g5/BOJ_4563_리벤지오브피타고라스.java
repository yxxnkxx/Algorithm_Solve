package Gold.g5;

import java.util.Scanner;

public class BOJ_4563_리벤지오브피타고라스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = 0;
		int cnt = 0;
		while (true) {
			A = sc.nextInt();

			if (A == 0)
				break;
			// 삼각형이 될 조건
			// c < a+b
			// c^2 = a^2 + b^2;
			// a2 = (b+c)(c-b)
			long A2 = (long) Math.pow(A, 2);
			// A의 약수 찾기
			for (long i = 1; i <= A; i++) {
				if (A2 % i == 0) {
					long sub = i;
					long sum = A2 / i;
					if ((sum - sub) / 2 > A && (sub - sum) % 2 == 0) {
						cnt++;
					}

				}
			}

			System.out.println(cnt);
			cnt = 0;

		}

	}

}
