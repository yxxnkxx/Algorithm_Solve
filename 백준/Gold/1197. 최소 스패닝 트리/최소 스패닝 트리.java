import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		long w;

		public Edge(int st, int ed, long w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}

	}

	static int V, E;
	static List<Edge>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++)
			adjList[i] = new ArrayList<>();

		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjList[st].add(new Edge(st, ed, w));
			adjList[ed].add(new Edge(ed, st, w)); // 무향 그래프
		}

		// 1번부터 시작
		visited[1] = true;
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.addAll(adjList[1]);
		int pick = 0;
		long ans = 0;

		while (pick < V - 1) {
			Edge e = q.poll();
			if (visited[e.ed])
				continue;

			ans += e.w;
			visited[e.ed] = true;
			pick++;
			q.addAll(adjList[e.ed]);

		}
		System.out.println(ans);

	}
}