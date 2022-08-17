package Silver.s3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655_N과M6 {

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
		boolean[] selected = new boolean[N];

		comb(arr, selected, 0, 0, M);
		System.out.println(sb.toString());

	}

	static void comb(int[] arr, boolean[] selected, int depth, int start, int M) {
		if (depth == M) {
			for (int i = 0; i < selected.length; i++) {
				if (selected[i])
					sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
			selected[i] = true;
			comb(arr, selected, depth + 1, i + 1, M); // i보다 큰 것만 검사해서 추가함
			selected[i] = false;
		}
	}

}
