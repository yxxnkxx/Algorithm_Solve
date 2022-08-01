// 다시 풀기

package BOJ0801;

import java.util.Scanner;

public class BOJ_15649_NandM {
	static boolean[] check;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		check = new boolean[N + 1];
		result = new int[M + 1];
		dfs(N, M, 0);

	}

	static void dfs(int N, int M, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				result[cnt] = i;
				dfs(N, M, cnt++);
				check[i] = false;

			}
		}

	}

}
