import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Vertex {
		int id;
		int x;
		int y;
		int z;

		public Vertex(int id, int x, int y, int z) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

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

	static int N;
	static Vertex[] pos;

	// 시간 초과
	// x기준 인접한 노드, y기준 인접한 노드, z기준 인접한 노드끼리만 연결해줘도 됨
	// 세 거리 중 최소값이 두 노드를 연결한 edge니까 이렇게 해서 정렬하면 최소 노드만 갈 수 있게 됨

	static List<Edge>[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pos = new Vertex[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pos[i] = new Vertex(i, x, y, z);

		}

		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();

		// x기준 정렬 후 간선 연결
		Arrays.sort(pos, new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Vertex v1 = pos[i];
			Vertex v2 = pos[i + 1];
			long dist = Math.abs(v1.x - v2.x);
			adjList[v1.id].add(new Edge(v1.id, v2.id, dist));
			adjList[v2.id].add(new Edge(v2.id, v1.id, dist));
		}
		// y 정렬
		Arrays.sort(pos, new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});

		for (int i = 0; i < N - 1; i++) {
			Vertex v1 = pos[i];
			Vertex v2 = pos[i + 1];
			long dist = Math.abs(v1.y - v2.y);
			adjList[v1.id].add(new Edge(v1.id, v2.id, dist));
			adjList[v2.id].add(new Edge(v2.id, v1.id, dist));
		}

		// z기준 정렬 후 간선 연결
		Arrays.sort(pos, new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				// TODO Auto-generated method stub
				return o1.z - o2.z;
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Vertex v1 = pos[i];
			Vertex v2 = pos[i + 1];
			long dist = Math.abs(v1.z - v2.z);
			adjList[v1.id].add(new Edge(v1.id, v2.id, dist));
			adjList[v2.id].add(new Edge(v2.id, v1.id, dist));
		}

		// prim
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(adjList[0]);
		visited[0] = true;
		int pick = 0;
		long ans = 0;

		while (pick < N - 1) {
			Edge e = pq.poll();
			if (visited[e.ed])
				continue;
			visited[e.ed] = true;
			pick++;
			ans += e.dist;
			pq.addAll(adjList[e.ed]);
		}
		System.out.println(ans);

	}
}