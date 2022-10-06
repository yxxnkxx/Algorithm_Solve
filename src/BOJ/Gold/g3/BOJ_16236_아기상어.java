package BOJ.Gold.g3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16236_아기상어 {

	static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int size;
		int dist;
		boolean visited;

		public Fish(int r, int c, int size, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
			this.visited = false;
		}

		@Override
		public int compareTo(Fish o) {

			if (this.dist == o.dist) {
				if (this.r == o.r)
					return this.c - o.c;
				return this.r - o.r;
			}
			return this.dist - o.dist;

		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", dist=" + dist + "]";
		}

	}

	static class Shark {
		int r;
		int c;
		int cnt;
		int size;

		public Shark(int r, int c, int cnt, int size) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.size = size;
		}

	}

	static int N;
	static List<Fish> list;
	static int[][] map;
	static boolean[][] visited;
	static int sec = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Shark s;
	static int route;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();
		N = sc.nextInt();
		map = new int[N][N];
		s = new Shark(0, 0, 0, 2);
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int val = sc.nextInt();
				map[i][j] = val;
				switch (val) {
				case 0:
					break;
				case 9:
					s.r = i;
					s.c = j;
					break;
				default:
					list.add(new Fish(i, j, val, 0));
				}
			}

		// val 순으로 정렬하기
		Collections.sort(list, new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				// TODO Auto-generated method stub
				return o1.size - o2.size;
			}
		});
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		// val이 1이고 이동 가능한 애들만 넣기
		for (int i = 0; i < list.size(); i++) {
			Fish f = list.get(i);
			if (f.size == 1) {
				route = isPossible(s.r, s.c, f.r, f.c);
				if (route != Integer.MAX_VALUE) {
					f.dist = route;
					pq.add(f);
				}
			}
			if (f.size > 1)
				break;
		}

		while (!pq.isEmpty()) {
			Fish f = pq.poll();
			f.visited = true;
			s.cnt++;
			sec += f.dist;
			map[s.r][s.c] = 0; // 지나온 곳은 0으로 만들기
			s.r = f.r;
			s.c = f.c; // 위치 변경
			pq.clear(); // 이미 있는 것도 위치를 다시 업데이트해야됨
			if (s.cnt == s.size) {
				s.cnt = 0;
				s.size++;
			}
			for (int i = 0; i < list.size(); i++) {
				Fish tmp = list.get(i);
				if (tmp.size > s.size)
					break;
				if (!tmp.visited && tmp.size < s.size) {
					route = isPossible(s.r, s.c, tmp.r, tmp.c);
					if (route != Integer.MAX_VALUE) {
						tmp.dist = route;
						pq.add(tmp);
					}
				}
			}
		}

		System.out.println(sec);

	}

	private static int isPossible(int sr, int sc, int fr, int fc) {
		// 이동 가능한지 검사하기

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], false);

		q.add(new int[] { sr, sc, 0 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == fr && tmp[1] == fc) {
				return tmp[2];
			}

			visited[tmp[0]][tmp[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] <= s.size) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, tmp[2] + 1 });
				}
			}
		}

		return Integer.MAX_VALUE;

	}

}
