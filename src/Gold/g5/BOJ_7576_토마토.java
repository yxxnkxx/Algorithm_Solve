package Gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int[][] map;
	static boolean[][] visited;
	static int N, M; // N은 row M은 col
	static int day = -1; // -1로 초기화, 모두 채울 수 없으면 -1 출력하도록
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		} // 입력

		bfs();
		System.out.println(day);
	}

	static void bfs() {
		Queue<Integer> q_r = new LinkedList<>(); // r을 담을 queue
		Queue<Integer> q_c = new LinkedList<>(); // c를 담을 queue
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q_r.add(i);
					q_c.add(j);
				}
			}

		while (!q_r.isEmpty()) {
			int r = q_r.poll();
			int c = q_c.poll();
			visited[r][c] = true;
			int data = map[r][c];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !visited[nr][nc]) {
					map[nr][nc] = data + 1; // day를 세기 편하게 하려고 이전 data(연결 노드)+1을 해줬음
					if (data > cnt)
						cnt = data; // cnt를 update
					q_r.add(nr);
					q_c.add(nc);
				}
			}
		}

		boolean checkZero = false;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					checkZero = true;
			}

		if (!checkZero) { // 0이 없으면 day를 update, 0이 있다면 그대로 -1 출력
			day = cnt;
			return;
		}

	}

}
