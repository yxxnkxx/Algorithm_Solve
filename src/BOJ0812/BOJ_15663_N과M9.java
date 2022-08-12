package BOJ0812;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15663_N과M9 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		boolean[] check = new boolean[N];
		int[] out = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		perm(arr, out, check, 0, M);
		System.out.print(sb.toString());

	}

	static void perm(int[] arr, int[] out, boolean[] visited, int depth, int M) {
		if (depth == M) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int before = 0; // 같은 깊이에서 before이 같은지 아닌지 확인
		// 정렬되어있으니 before 값만 확인하면 됨
		// 나머지는 순열과 동일
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i] && before != arr[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				perm(arr, out, visited, depth + 1, M);
				before = arr[i];
				visited[i] = false;

			}
		}

	}

}