import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M; // N은 row M은 col
	static int day = -1;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 사방탐색으로 bfs 근데 같은 층위에 있는 애들은 cnt를 1만 더해줘야함..
		// a와 인접한 노드를 모두 추가(a1, a2) a1과 인접한 노드 추가, a2와 인접한 노드 추가-> 2일
		// 0을만나면 계속, -1을 만나면 빽해야됨
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
		}
		bfs();
		System.out.println(day);
	}

	static void bfs() {
		Queue<Integer> q_r = new LinkedList<>();
		Queue<Integer> q_c = new LinkedList<>();
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
					map[nr][nc] = data + 1;
					if (data > cnt)
						cnt = data;
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

		if (!checkZero) {
			day = cnt;
			return;
		}

	}

}