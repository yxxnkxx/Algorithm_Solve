package BOJ.Silver.s1;

import java.util.Scanner;

public class BOJ_1629_곱셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		System.out.println(pow(A, B, C));
	}

	static long pow(long A, long B, long C) {
		if (B == 1)
			return A % C;
		long tmp = pow(A, B / 2, C);
		if (B % 2 == 1)
			return (tmp * tmp % C) * A % C;
		return tmp * tmp % C;

	}
}
