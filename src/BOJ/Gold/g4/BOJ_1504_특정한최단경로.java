package BOJ.Gold.g4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1504_특정한최단경로 {

	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		long dist;

		public Edge(int st, int ed, long dist) {
			this.st = st;
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}

	}

	static int N, E;
	static ArrayList<Edge>[] adjList;
	static long[][] dist;
	static boolean[] visited;
	static final long INF = 200000000; // edge 최대 200,000 dist 최대 1000

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			long dist = sc.nextLong();
			adjList[st].add(new Edge(st, ed, dist));
			adjList[ed].add(new Edge(ed, st, dist));
		}

		dist = new long[3][N + 1];
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		// dijkstra: 1, v1, v2
		dijkstra(1, 0);
		dijkstra(v1, 1);
		dijkstra(v2, 2);
		// 1-v1 v2-N
		// 1-v2 v1-N
		// 두 정점을 바로 지나는 것이지 v1-v2를 잇는 선만 지나야할 필요는 없음...
		long ans1 = dist[0][v1] + dist[1][v2] + dist[2][N];
		long ans2 = dist[0][v2] + dist[2][v1] + dist[1][N];
		if (ans1 >= INF && ans2 >= INF)
			System.out.println(-1);
		else
			System.out.println(Math.min(ans1, ans2));

	}

	static void dijkstra(int st, int idx) {
		Arrays.fill(dist[idx], INF);
		dist[idx][st] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited = new boolean[N + 1];

		pq.add(new Edge(st, st, 0));
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.ed])
				continue;
			visited[e.ed] = true;

			for (int i = 0; i < adjList[e.ed].size(); i++) {
				Edge tmp = adjList[e.ed].get(i);
				if (!visited[tmp.ed] && dist[idx][tmp.ed] > dist[idx][tmp.st] + tmp.dist) {
					dist[idx][tmp.ed] = dist[idx][tmp.st] + tmp.dist;
					pq.add(new Edge(tmp.st, tmp.ed, dist[idx][tmp.ed]));
				}
			}
		}
	}

}
