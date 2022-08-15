package BOJ0815;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15664_N과M10 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];

		int[] out = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		comb(arr, out, 0, 0, M);
		System.out.print(sb.toString());

	}

	static void comb(int[] arr, int[] out, int start, int depth, int M) {
		if (depth == M) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int before = 0;
		for (int i = start; i < arr.length; i++) {
			if (before != arr[i]) { // 순열에서와 동일
				out[depth] = arr[i];
				comb(arr, out, i + 1, depth + 1, M); // start 변수 추가
				before = arr[i];

			}
		}

	}
}
