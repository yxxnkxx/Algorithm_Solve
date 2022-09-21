package Gold.g4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2448_별찍기11 {
	static int N;
	static int K;

	static char[][] stars;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stars = new char[N][2 * N];
		for (char[] ch : stars) {
			Arrays.fill(ch, ' ');
		}

		star(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < 2 * N; j++)
				sb.append(stars[i][j]);
			sb.append("\n");
		}
		System.out.print(sb);

	}

	static void star(int idx) {
		if (idx == N)
			return;

		if (idx == 0) {
			stars[0][N] = '*';
			stars[1][N - 1] = '*';
			stars[1][N + 1] = '*';
			for (int i = 0; i <= 2; i++) {
				stars[2][N - i] = '*';
				stars[2][N + i] = '*';
			}
			star(3);
		} else {
			for (int i = idx; i < idx * 2; i++) {
				for (int start = N - idx + 1; start <= N + idx - 1; start++) {
					stars[i][start - idx] = stars[i - idx][start];
					stars[i][start + idx] = stars[i - idx][start];
				}
			}
			star(idx * 2);
		}

	}

}
