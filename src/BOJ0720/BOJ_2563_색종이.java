package BOJ0720;

import java.util.Scanner;

public class BOJ_2563_색종이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[100][100];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int dx = x; dx < x + 10; dx++) {
				for (int dy = y; dy < y + 10; dy++) {
					arr[dx][dy] = 1;
				}
			}

		}

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}

}
