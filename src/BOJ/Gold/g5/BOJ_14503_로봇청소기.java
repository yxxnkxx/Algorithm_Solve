package BOJ.Gold.g5;

import java.util.Scanner;

public class BOJ_14503_로봇청소기 {

	static int[] dr = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int N, M;
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int R = sc.nextInt();
		int C = sc.nextInt();
		int dir = sc.nextInt();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();

		// 1은 벽, 방문한 곳도 1로 만들기
		dfs(R, C, dir);
		System.out.println(cnt - 1);

	}

	static void dfs(int R, int C, int dir) {
		if (map[R][C] == 0)
			map[R][C] = ++cnt; // 청소하기
		boolean check = false;
		for (int d = 1; d <= 4; d++) {
			// 왼쪽으로 회전: dir-1, dir-2 ...
			int nd = (4 + dir - d) % 4;
			int nr = R + dr[nd];
			int nc = C + dc[nd];
			if (map[nr][nc] == 0) {
				check = true;
				dfs(nr, nc, nd);
				break;
			}
			// 네 방향 모두 벽: 후진하기
		}
		if (!check) {
			int nr = R - dr[dir];
			int nc = C - dc[dir];
			if (map[nr][nc] != 1)
				// 후진해서 넣기
				dfs(nr, nc, dir); // 후진해서 넣을때의 방향 문제
			// https://www.acmicpc.net/board/view/34448
			// 이미 방문했더라도 벽을 만날때까지 후진하기
		}

	}

}
