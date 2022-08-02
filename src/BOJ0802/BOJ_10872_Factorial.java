package BOJ0802;

import java.util.Scanner;

public class BOJ_10872_Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(factorial(N));

	}

	static int factorial(int N) {
		if (N == 1 || N == 0) {
			return 1;
		} else {
			return N * factorial(N - 1);
		}
	}
}
