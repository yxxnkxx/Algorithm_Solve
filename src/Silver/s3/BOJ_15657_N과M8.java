package Silver.s3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15657_N과M8 {
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
		System.out.println(sb.toString());

	}

	static void comb(int[] arr, int[] out, int depth, int start, int M) {
		if (depth == M) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
			out[depth] = arr[i];
			comb(arr, out, depth + 1, i, M);

		}
	}

}
