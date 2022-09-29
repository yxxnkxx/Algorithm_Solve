package BOJ.Silver.s3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654_N과M5 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int[] out = new int[M];
		boolean[] visited = new boolean[N];
		perm(arr, out, visited, 0, M);
		System.out.println(sb.toString());

	}

	static void perm(int[] arr, int[] out, boolean[] visited, int depth, int M) {
		if (depth == M) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				perm(arr, out, visited, depth + 1, M);
				visited[i] = false;

			}
		}

	}

}
