package BOJ0728;

import java.util.Scanner;

public class BOJ_4948_베르트랑공준 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		while (N != 0) {
			int[] arr = new int[2 * N + 1];
			for (int i = 2; i <= 2 * N; i++)
				arr[i] = i;

			for (int i = 2; i <= 2 * N; i++) {
				if (arr[i] == 0) // 이미 지워진거면 pass
					continue;

				for (int j = i * 2; j <= 2 * N; j += i)
					// i의 배수를 찾아서 지움, 이때 i는 제외
					arr[j] = 0;
			}
			int cnt = 0;
			for (int i = N + 1; i <= 2 * N; i++) {
				if (arr[i] != 0)
					cnt++;
			}
			System.out.println(cnt);

			N = sc.nextInt();
		}

	}

}
