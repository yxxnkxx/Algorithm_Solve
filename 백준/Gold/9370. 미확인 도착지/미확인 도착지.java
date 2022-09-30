import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
			return this.dist - o.dist;
		}

	}

	static int n, m, t;
	static int s, g, h;
	static List<Edge>[] adjList;
	static int[] edArr;
	static int[][] dist;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			n = sc.nextInt(); // vertex
			m = sc.nextInt(); // edge
			t = sc.nextInt(); // 목적지 후보
			s = sc.nextInt(); // 시작점
			g = sc.nextInt(); // 반드시 거쳐야하는 교차로
			h = sc.nextInt();
			adjList = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++)
				adjList[i] = new ArrayList<>();
			int edge = 0;
			// edge adjList
			while (m-- > 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int d = sc.nextInt();
				adjList[a].add(new Edge(a, b, d));
				adjList[b].add(new Edge(b, a, d));
				if ((a == g && b == h) || a == h && b == g)
					edge = d;
			}

			edArr = new int[t];
			for (int i = 0; i < t; i++)
				edArr[i] = sc.nextInt();
			Arrays.sort(edArr); // 후보지는 오름차순으로 출력

//			for (int i = 0; i < t; i++) {
//				if (dijkstra(s, edArr[i]))
//					check = true; // 각각의 후보지에 대해 dijkstra -> 이러면 시간 초과 그냥 dijkstra를 끝까지 돌린 다음 후보지를 확인해야함
//			}

			dist = new int[3][n + 1]; // 0은 s, 1은 g에서 시작, 2는 h에서 시작
			dijkstra(s, 0);
			dijkstra(g, 1);
			dijkstra(h, 2);
			// s->ed = s-g-h-ed 라면 ok 무향이니까 s-h-g-ed도 ok
			boolean check = false;
			for (int i = 0; i < t; i++) {
				int ed = edArr[i];
				if ((dist[0][ed] == dist[0][g] + edge + dist[2][ed])
						|| dist[0][ed] == dist[0][h] + edge + dist[1][ed]) {
					sb.append(ed + " ");
					check = true;
				}
			}
			if (check)
				sb.append("\n");

		}
		System.out.println(sb);
	}

	static void dijkstra(int st, int idx) {

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(dist[idx], Integer.MAX_VALUE);
		dist[idx][st] = 0;
		// start에서 연결된 edge들을 pq에 추가
		for (int i = 0; i < adjList[st].size(); i++) {
			Edge e = adjList[st].get(i);
			dist[idx][e.ed] = e.dist;
			pq.add(e);
		}
		visited[st] = true;

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.ed])
				continue;

//			if ((e.st == g && e.ed == h) || (e.st == h && e.ed == g)) {
//				sb.append(ed).append(" ");
//				return;
//			} // 이렇게하면 목적지까지 최단 경로가 아님에도 포함한다고 인식함

			visited[e.ed] = true;
			for (Edge tmp : adjList[e.ed]) {
				if (!visited[tmp.ed] && dist[idx][tmp.ed] > dist[idx][tmp.st] + tmp.dist) {
					dist[idx][tmp.ed] = dist[idx][tmp.st] + tmp.dist;
					pq.add(new Edge(tmp.st, tmp.ed, dist[idx][tmp.ed]));
				}
			}

		}

	}

}