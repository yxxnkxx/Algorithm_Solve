package Gold.g4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2448_별찍기11_분할정복 {
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

		star(0, N - 1, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N; j++)
				sb.append(stars[i][j]);
			sb.append("\n");
		}
		System.out.print(sb);

	}

	static void star(int row, int col, int size) {
		if (size == 3) {
			stars[row][col] = '*';
			stars[row + 1][col - 1] = stars[row + 1][col + 1] = '*';
			for (int i = 0; i <= 2; i++) {
				stars[row + 2][col - i] = '*';
				stars[row + 2][col + i] = '*';
			}
			return;
		}

		size /= 2;
		star(row, col, size);
		star(row + size, col + size, size);
		star(row + size, col - size, size);
	}

}
