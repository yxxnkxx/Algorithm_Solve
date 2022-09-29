package BOJ.Silver.s2;

import java.util.Scanner;
import java.util.TreeSet;

public class BOJ_15665_N과M11 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		TreeSet<Integer> treeSet = new TreeSet<>();

		int[] out = new int[M];

		for (int i = 0; i < N; i++) {
			treeSet.add(sc.nextInt());
		}

		Integer[] arr = treeSet.toArray(new Integer[0]);
		perm(arr, out, 0, M);
		System.out.print(sb.toString());

	}

	static void perm(Integer[] arr, int[] out, int depth, int M) {
		if (depth == M) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int before = 0;
		for (int i = 0; i < arr.length; i++) {

			out[depth] = arr[i];
			perm(arr, out, depth + 1, M);

		}
	}

}
