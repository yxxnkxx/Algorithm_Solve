package BOJ0802;

import java.util.Scanner;

public class BOJ_1070_Fibonacci2 {
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N + 2];
		arr[0] = 0;
		arr[1] = 1;
		System.out.println(fibonacci(N));
	}

	static int fibonacci(int N) {
		if (N == 0 || N == 1) {
			return arr[N];
		} else {
			if (arr[N] == 0) {
				int tmp = fibonacci(N - 1) + fibonacci(N - 2);
				arr[N] = tmp;
				return arr[N];

			} else {
				return arr[N];
			}

		}
	}

}
