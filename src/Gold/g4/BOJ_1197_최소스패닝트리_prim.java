package Gold.g4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1197_최소스패닝트리_prim {

	static class Edge {
		int ed;
		int w;

		public Edge(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}

	}

	static int V, E;
	static List<Edge>[] adjList;
	static int[] weights;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		adjList = new ArrayList[V];
		weights = new int[V];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjList[st].add(new Edge(ed, w));
			adjList[ed].add(new Edge(st, w)); // 무향 그래프
		}

	}
}
