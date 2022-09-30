import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		int w;

		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	static int V, E;
	static List<Edge>[] adjList;
	static int[] dist;
	static boolean[] visited;
	static int K;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();

		adjList = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			adjList[i] = new ArrayList<>();

		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjList[st].add(new Edge(st, ed, w)); // 유향그래프

		}

		//////// dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < adjList[K].size(); i++) {
			Edge e = adjList[K].get(i);
			dist[e.ed] = Math.min(dist[e.ed], e.w); // 두 노드 사이에 중복된 간선이 있을 경우 최소 값으로 갱신해야 함 ex. 1: (2,3) (2,5)
			pq.add(e);
		}

		visited[K] = true;
		dist[K] = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.ed])
				continue;
			visited[e.ed] = true;

			// 인접 노드 갱신
			for (int i = 0; i < adjList[e.ed].size(); i++) {
				Edge tmp = adjList[e.ed].get(i);
				if (!visited[tmp.ed]) {
					dist[tmp.ed] = Math.min(dist[tmp.ed], dist[tmp.st] + tmp.w);
					pq.add(new Edge(tmp.st, tmp.ed, dist[tmp.ed]));
				}

			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				sb.append("INF");
			else
				sb.append(dist[i]);
			sb.append("\n");
		}
		System.out.print(sb);

	}
}