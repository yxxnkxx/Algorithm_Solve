package BOJ0812;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15656_N과M7 {
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
		perm(arr, out, 0, M);
		System.out.println(sb.toString());

	}

	static void perm(int[] arr, int[] out, int depth, int M) {
		if (depth == M) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			out[depth] = arr[i];
			perm(arr, out, depth + 1, M);

		}
	}

}
