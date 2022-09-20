package Gold.g4;

import java.util.Scanner;

public class BOJ_10830_행렬제곱 {

	static long[][] map;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong(); // 범위 long

		map = new long[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextLong();

		long[][] result = mul(B);
		for (long[] arr : result) {
			for (int i = 0; i < N; i++)
				System.out.print(arr[i] % 1000 + " "); // 처음부터 arr[i]가 1000일 경우 1000이 아니라 0 출력하기
			System.out.println();
		}
	}

	static long[][] mul(long B) {
		if (B == 1)
			return map;
		long[][] tmp = mul(B / 2);
		if (B % 2 == 0)
			return multiMatrix(tmp, tmp);
		else
			return multiMatrix(multiMatrix(tmp, tmp), map);

	}

	static long[][] multiMatrix(long[][] a, long[][] b) {
		long[][] tmp = new long[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < N; d++)
					tmp[i][j] = (tmp[i][j] + a[d][j] * b[i][d]) % 1000;

			}

		return tmp;
	}
}
