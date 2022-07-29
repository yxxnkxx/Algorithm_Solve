package BOJ0729;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2447_별찍기10_arr {
	static char[][] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		int cnt = 1;
		arr = new char[N][N];
		stars(0, 0, N);
		for (int i = 0; i < N; i++) {
			bw.write(arr[i]);
			bw.newLine();
		}
		bw.flush();
	}

	static void stars(int x, int y, int N) {

	}

}
