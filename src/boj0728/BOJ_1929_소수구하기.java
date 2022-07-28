package boj0728;

import java.util.Scanner;

public class BOJ_1929_소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 2; i <= N; i++)
			arr[i] = i;

		for (int i = 2; i <= N; i++) {
			if (arr[i] == 0) // 이미 지워진거면 pass
				continue;

			for (int j = i * 2; j <= N; j += i)
				// i의 배수를 찾아서 지움, 이때 i는 제외
				arr[j] = 0;

		}

		for (int i = M; i <= N; i++) {
			if (arr[i] != 0)
				System.out.println(arr[i]);

		}

	}
}
