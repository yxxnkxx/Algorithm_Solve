package BOJ.Gold.g3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_말이되고픈원숭이 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] horser = { -2, 2, -1, 1, -2, 2, -1, 1 };
	static int[] horsec = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++)
				map[i][j] = sc.nextInt();
		bfs(0, 0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, 0, 0 }); // r좌표, c좌표, 이동 거리, K
		// 방문 처리는 horse로 이동한 경우와 그냥 이동한 경우를 나눠서
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == H - 1 && tmp[1] == W - 1) {
				ans = Math.min(tmp[2], ans);
			}
			if (visited[tmp[0]][tmp[1]][tmp[3]])
				continue;
			visited[tmp[0]][tmp[1]][tmp[3]] = true;
			if (tmp[3] < K) {
				for (int d = 0; d < 8; d++) {
					int nr = tmp[0] + horser[d];
					int nc = tmp[1] + horsec[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && !visited[nr][nc][tmp[3] + 1])
						q.add(new int[] { nr, nc, tmp[2] + 1, tmp[3] + 1 });
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && !visited[nr][nc][tmp[3]])
					q.add(new int[] { nr, nc, tmp[2] + 1, tmp[3] });
			}
		}
	}

}
