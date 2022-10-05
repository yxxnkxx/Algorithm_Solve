package BOJ.Gold.g4;

import java.util.Scanner;

public class BOJ_16202_MST게임 {

	static int N, M, K;
	static int[] ans;
	static int[][] edges;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		ans = new int[K];
		edges = new int[M + 1][2];
		for (int i = 1; i <= M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			edges[i] = new int[] { st, ed };
		}
		p = new int[N + 1];

		for (int k = 0; k < K; k++) {
			// 0번째에는 1부터 검사, 1번째에는 2부터 검사, k번째는 k+1부터 검사해서 mst 찾기
			int length = 0;
			int pick = 0;
			int idx = k + 1;
			// 초기화
			for (int i = 1; i <= N; i++)
				p[i] = i;

			while (pick < N - 1 && idx <= M) {
				int st = edges[idx][0];
				int ed = edges[idx][1];
				int w = idx;
				int pst = findSet(st);
				int ped = findSet(ed);
				if (pst != ped) {
					p[ped] = p[pst];
					length += w;
					pick++;
				}
				idx++;
			}
			if (pick < N - 1) {
				ans[k] = 0;
				break;
			} else
				ans[k] = length;
		}
		for (int i = 0; i < K; i++)
			System.out.print(ans[i] + " ");
		System.out.println();

	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

}
