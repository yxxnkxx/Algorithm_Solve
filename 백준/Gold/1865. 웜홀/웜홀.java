import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge> {
		int ed;
		int dist;

		public Edge(int ed, int dist) {
			super();
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}

	// 벨만포드
	static int N, M, W;
	static List<Edge>[] adjList;
	static int[] ans;
	static final int INF = 5000001;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		label: while (T-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			W = sc.nextInt();
			adjList = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				adjList[i] = new ArrayList<>();
			// 무향그래프
			for (int i = 0; i < M; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				int dist = sc.nextInt();
				adjList[st].add(new Edge(ed, dist));
				adjList[ed].add(new Edge(st, dist));
			}

			for (int i = 0; i < W; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				int dist = sc.nextInt();
				adjList[st].add(new Edge(ed, dist * -1)); // 단방향
			}
			ans = new int[N + 1];
			Arrays.fill(ans, INF);
			// 시작점은 0으로 초기화
			ans[1] = 0;
			// 벨만포드
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= N; j++)
					for (int k = 0; k < adjList[j].size(); k++) {
						Edge e = adjList[j].get(k);
						if (ans[e.ed] > ans[j] + e.dist) {
							ans[e.ed] = ans[j] + e.dist;
							if (i == N - 1) {
								sb.append("YES").append("\n");
								continue label;
							}
						}
					}
			}
			sb.append("NO").append("\n");

		}
		System.out.print(sb);
	}
}