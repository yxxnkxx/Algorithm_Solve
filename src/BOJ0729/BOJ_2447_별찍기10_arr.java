package BOJ0729;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2447_별찍기10_arr {
	static char[][] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		arr = new char[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(arr[i], ' ');

		stars(0, 0, N);
		for (int i = 0; i < N; i++) {
			bw.write(arr[i]);
			bw.newLine();
		}
		bw.flush();
	}

	static void stars(int x, int y, int N) {
		System.out.println(x + " " + y + " " + N);
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue; // i와 j가 1일 때는 공백

				stars(x + (N / 3) * i, y + (N / 3) * j, N / 3);
				// N/3을 기준으로 가운데(i=1, j=1)일 때는 공백임 -> 이걸 재귀로 반복
			}
		}

	}

}
