package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {

	static class Edge implements Comparable<Edge> {

		int st;
		int ed;
		double dist;

		public Edge(int st, int ed, double dist) {
			super();
			this.st = st;
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.dist, o.dist);
		}
	}

	static int N;
	static int[][] map;
	static double rate;
	static ArrayList<Edge>[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][2]; // x와 y좌표를 담음
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				map[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				map[i][1] = Integer.parseInt(st.nextToken());
			rate = Double.parseDouble(br.readLine());

			adjList = new ArrayList[N];
			for (int i = 0; i < N; i++)
				adjList[i] = new ArrayList<>();

			// st, ed는 map에서의 index
			for (int i = 0; i < N - 1; i++)
				for (int j = i + 1; j < N; j++) {
					long ix = map[i][0];
					long iy = map[i][1];
					long jx = map[j][0];
					long jy = map[j][1];
					double dist = (Math.pow(ix - jx, 2) + Math.pow(iy - jy, 2)) * rate;
					adjList[i].add(new Edge(i, j, dist));
					adjList[j].add(new Edge(j, i, dist));
				}

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(adjList[0]);
			boolean[] visit = new boolean[N];
			visit[0] = true;
			int pick = 0;
			double ans = 0;
			while (pick < N - 1) {
				Edge e = pq.poll();
				if (visit[e.ed])
					continue;
				visit[e.ed] = true;
				ans += e.dist;
				pick++;
				pq.addAll(adjList[e.ed]);
			}
			System.out.println("#" + t + " " + Math.round(ans));
		}
	}

}
