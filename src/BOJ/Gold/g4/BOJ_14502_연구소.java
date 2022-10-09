package BOJ.Gold.g4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502_연구소 {
	static int N, M;
	static int[][] map;
	static List<int[]> space;
	static List<int[]> virus;
	static int[][] pick;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		space = new ArrayList<>();
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				int v = sc.nextInt();
				map[i][j] = v;
				if (v == 0)
					space.add(new int[] { i, j }); // 벽을 세울 수 있는 공간
				if (v == 2)
					virus.add(new int[] { i, j });
			}
		// 벽을 세울 수 있는 공간에서 3개를 뽑는 조합
		pick = new int[3][2];
		comb(0, 0);
		System.out.println(ans);
	}

	static void comb(int depth, int start) {
		if (depth == 3) {
			// 원래 맵 복사
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; i++)
				copy[i] = map[i].clone();

			spread();
			for (int i = 0; i < N; i++)
				map[i] = copy[i].clone();
			return;
		}

		for (int i = start; i < space.size(); i++) {
			pick[depth][0] = space.get(i)[0];
			pick[depth][1] = space.get(i)[1];
			comb(depth + 1, i + 1);
		}
	}

	static void spread() {
		for (int i = 0; i < 3; i++) {
			map[pick[i][0]][pick[i][1]] = 1; // 벽 세우기
		}
		// bfs 실행하기
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++)
			q.add(new int[] { virus.get(i)[0], virus.get(i)[1] });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (visited[tmp[0]][tmp[1]])
				continue;
			visited[tmp[0]][tmp[1]] = true;
			map[tmp[0]][tmp[1]] = 2;
			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0)
					q.add(new int[] { nr, nc });

			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 0)
					cnt++;
		ans = Math.max(ans, cnt);
	}

}
