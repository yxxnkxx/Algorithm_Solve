import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Star {
		int idx;
		double x;
		double y;

		public Star(int idx, double x, double y) {
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

	}

	static int N;
	static Star[] stars;
	static ArrayList<Edge>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stars = new Star[N];
		for (int i = 0; i < N; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			stars[i] = new Star(i, x, y);
		}
		adjList = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<Edge>();

		// 모든 edge 연결하기
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++) {
				double dist = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
				adjList[i].add(new Edge(i, j, dist));
				adjList[j].add(new Edge(j, i, dist));
			}

		// prim
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		double ans = 0;
		visited[0] = true;
		pq.addAll(adjList[0]);
		int pick = 0;
		while (pick < N - 1) {
			Edge tmp = pq.poll();
			if (visited[tmp.ed])
				continue;
			ans += tmp.dist;
			pick++;
			visited[tmp.ed] = true;
			pq.addAll(adjList[tmp.ed]);
		}
		System.out.printf("%.2f", ans);

	}
}