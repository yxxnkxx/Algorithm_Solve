import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static boolean[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Island[] vertexes;
	static int cnt;
	static ArrayList<Edge> edges;
	static int edgeCnt;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new boolean[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = (sc.nextInt() == 1) ? true : false;

		vertexes = new Island[6]; // 섬은 최대 6개
		cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] && !visited[i][j]) {
					vertexes[cnt] = new Island(cnt);
					vertexes[cnt].pos.add(new int[] { i, j });
					find(i, j);
					cnt++;
				}

		// 간선 만들기
		edges = new ArrayList<>();
		edgeCnt = 0;
		// cnt = 섬의 개수
		for (int i = 0; i < cnt - 1; i++)
			for (int j = i + 1; j < cnt; j++) {
				findEdge(i, j);
				edgeCnt++;
			}

		// 크루스칼
		Collections.sort(edges);
		p = new int[cnt];
		// make-set
		for (int i = 0; i < cnt; i++)
			p[i] = i;
		// edge 선택
		int ans = 0;
		int pick = 0;
		for (int i = 0; i < edgeCnt; i++) {
			Edge e = edges.get(i);
			if (e.length == -1 || e.length == Integer.MAX_VALUE)
				continue;
			int start = findSet(e.start);
			int end = findSet(e.end);
			if (start != end) {
				union(start, end);
				ans += e.length;
				pick++;
			}
			if (pick == cnt - 1)
				break;
		}
		if (pick < cnt - 1)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);

	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void find(int r, int c) {

		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] && !visited[nr][nc]) {
				vertexes[cnt].pos.add(new int[] { nr, nc });
				find(nr, nc);
			}
		}

	}

	static void findEdge(int i, int j) {
		// 가장 최소의 edge를 찾아야함
		Island isA = vertexes[i];
		Island isB = vertexes[j];

		int sizeA = isA.pos.size();
		int sizeB = isB.pos.size();

		edges.add(new Edge(i, j, Integer.MAX_VALUE));

		for (int a = 0; a < sizeA; a++)
			label: for (int b = 0; b < sizeB; b++) {
				int rA = isA.pos.get(a)[0];
				int cA = isA.pos.get(a)[1];
				int rB = isB.pos.get(b)[0];
				int cB = isB.pos.get(b)[1];

				// 가로 edge
				if (rA == rB) {
					int length = Math.abs(cB - cA) - 1;
					if (length == 1)
						continue label;
					else {
						// 간선 사이에 map이 1이면 안됨
						int start = (cB > cA) ? cA : cB;
						int end = (cB > cA) ? cB : cA;
						for (int s = start + 1; s <= end - 1; s++)
							if (map[rA][s])
								continue label;

						if (edges.get(edgeCnt).length > length && length >= 2) {
							edges.set(edgeCnt, new Edge(i, j, length)); // 길이가 작은 edge로 업데이트하기}
						}
					}
				}
				if (cA == cB) {
					int length = Math.abs(rB - rA) - 1;
					if (length == 1)
						continue label;

					else {
						// 간선 사이에 map이 1이면 안됨
						int start = (rB > rA) ? rA : rB;
						int end = (rB > rA) ? rB : rA;
						for (int s = start + 1; s <= end - 1; s++)
							if (map[s][cA])
								continue label;

						if (edges.get(edgeCnt).length > length && length >= 2) {
							edges.set(edgeCnt, new Edge(i, j, length)); // 길이가 작은 edge로 업데이트하기
						}
					}
				}

			}
	}

}

class Island {
	ArrayList<int[]> pos;
	int id;

	public Island(int id) {
		this.pos = new ArrayList<>();
		this.id = id;
	}

//	@Override
//	public String toString() {
//		return "Island " + id + " " + pos.get(0)[0] + " " + pos.get(0)[1] + " size=" + pos.size();
//	}

}

class Edge implements Comparable<Edge> {
	int start; // id로 판별
	int end;
	int length;

	public Edge(int start, int end, int length) {
		this.start = start;
		this.end = end;
		this.length = length;
	}

	@Override
	public int compareTo(Edge o) {
		return this.length - o.length;
	}

	// @Override
//	public String toString() {
//		return "start " + start + " end " + end + " length " + length;
//	}

}