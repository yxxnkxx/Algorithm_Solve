package BOJ.Gold.g3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1774_우주신과의교감 {

	static class God {
		int idx;
		long x;
		long y;

		public God(int idx, long x, long y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}

	}

	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		double dist;

		public Edge(int st, int ed, double dist) {
			this.st = st;
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return st + " " + ed + " " + dist;
		}
	}

	static int N, M;
	static God[] gods;
	static ArrayList<Edge>[] adjList;
	static boolean[] visited;
	static int[] p;
	static int pick;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		gods = new God[N + 1];
		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Edge>();

		p = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			gods[i] = new God(i, x, y);
			p[i] = i;
		}

		for (int i = 1; i <= N - 1; i++)
			for (int j = i + 1; j <= N; j++) {
				double dist = Math.sqrt(Math.pow(gods[i].x - gods[j].x, 2) + Math.pow(gods[i].y - gods[j].y, 2));
				adjList[i].add(new Edge(i, j, dist));
				adjList[j].add(new Edge(j, i, dist));
			}

		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			for (int j = 0; j < adjList[st].size(); j++)
				if (adjList[st].get(j).ed == ed)
					adjList[st].set(j, new Edge(st, ed, 0));
			for (int j = 0; j < adjList[ed].size(); j++)
				if (adjList[ed].get(j).ed == st)
					adjList[ed].set(j, new Edge(ed, st, 0));
			union(st, ed);
		}
		// 방문되지 않은 노드들에 대해 edge를 추가하기
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i < adjList.length; i++)
			pq.addAll(adjList[i]);

		double ans = 0;
		int pick = 0;

		while (!pq.isEmpty()) {
			Edge tmp = pq.poll();
			if (findSet(tmp.st) == findSet(tmp.ed))
				continue;
			ans += tmp.dist;
			union(tmp.st, tmp.ed);
			pick++;
		}
		System.out.printf("%.2f", ans);

	}

	static void union(int st, int ed) {
		int p1 = findSet(st);
		int p2 = findSet(ed);
		if (p1 != p2) {
			p[p2] = p1; // union

		}
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

}
