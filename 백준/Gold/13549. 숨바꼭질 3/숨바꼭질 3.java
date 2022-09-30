import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		int dist;

		public Edge(int st, int ed, int dist) {
			this.st = st;
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
	}

	static final int MAX = 100000;
	static boolean[] visited = new boolean[100001];
	static int[] dist = new int[100001];
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// N에 연결된 edge 3개 추가
		dist[N] = 0;
		if (N - 1 >= 0) {
			pq.add(new Edge(N, N - 1, 1));
			dist[N - 1] = 1;
		}
		if (N + 1 <= MAX) {
			pq.add(new Edge(N, N + 1, 1));
			dist[N + 1] = 1;
		}
		if (N * 2 <= MAX) {
			pq.add(new Edge(N, 2 * N, 0));
			dist[N * 2] = 0;
		}

		while (!visited[K]) {
			Edge e = pq.poll();
			if (visited[e.ed])
				continue;

			visited[e.ed] = true;
			// ed*2
			if (e.ed * 2 <= MAX && dist[e.ed * 2] > dist[e.ed])
				dist[e.ed * 2] = dist[e.ed];

			if (e.ed * 2 <= MAX)
				pq.add(new Edge(e.ed, e.ed * 2, dist[e.ed * 2]));
			// ed-1
			if (e.ed - 1 >= 0 && dist[e.ed - 1] > dist[e.ed] + 1)
				dist[e.ed - 1] = dist[e.ed] + 1;
			if (e.ed - 1 >= 0)
				pq.add(new Edge(e.ed, e.ed - 1, dist[e.ed - 1]));

			// ed+1
			if (e.ed + 1 <= MAX && dist[e.ed + 1] > dist[e.ed] + 1)
				dist[e.ed + 1] = dist[e.ed] + 1;
			if (e.ed + 1 <= MAX)
				pq.add(new Edge(e.ed, e.ed + 1, dist[e.ed + 1]));

		}
		System.out.println(dist[K]);
	}

}