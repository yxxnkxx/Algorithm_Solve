import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static class Edge {
		int st;
		int ed;
		long w;

		public Edge(int st, int ed, long w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

	}

	static int V, E;
	static Edge[] adjArr;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		adjArr = new Edge[E];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjArr[i] = new Edge(st, ed, w);
		}

		Arrays.sort(adjArr, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Long.compare(o1.w, o2.w);
			}
		});

		p = new int[V + 1];
		// make-set
		for (int i = 1; i <= V; i++)
			p[i] = i;

		long ans = 0;
		for (int i = 0; i < E; i++) {
			int st = adjArr[i].st;
			int ed = adjArr[i].ed;
			long w = adjArr[i].w;
			int setX = findSet(st);
			int setY = findSet(ed);
			if (setX != setY) {// cycle 아님
				// union
				p[setY] = p[setX];
				ans += w;
			}
		}
		System.out.println(ans);

	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

}