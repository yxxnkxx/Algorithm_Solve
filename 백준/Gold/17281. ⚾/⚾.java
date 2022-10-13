import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;

	static boolean[] visited;
	static int[] order;

	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[9];
		order = new int[9];

		// 순열
		order[3] = 0;
		visited[0] = true; // 4번타자로 고정
		perm(0);
		System.out.println(ans);

		// 게임 진행
	}

	static void perm(int depth) {
		if (depth == 9) {
			game();
			return;
		}

		if (depth == 3) {
			perm(depth + 1);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				order[depth] = i;
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false;
			}
		}

	}

	static void game() {
		int out = 0;
		int gameCnt = 0;
		int score = 0;
		int curr = 0;
		List<int[]> field = new LinkedList<>();

		while (gameCnt < N) {
			int player = order[curr];
			curr = (curr + 1) % 9;
			int result = arr[gameCnt][player];
			if (result == 0) {
				out++;
				if (out == 3) {
					gameCnt++;
					out = 0; // 다음 이닝으로
					field.clear(); // 필드 초기화
				}
			} else {
				field.add(new int[] { player, 0 });
				if (result == 4) {
					score += field.size();
					field.clear();
					continue;
				}
				// 필드에 나가있는 선수가 있으면 진루하기
				int size = field.size();
				for (int i = size - 1; i >= 0; i--) {
					int[] tmp = field.get(i);
					if (tmp[1] + result >= 4) {
						field.remove(tmp);
						score++;
					} else {
						tmp[1] += result;
					}
				}

			}
		}
		ans = Math.max(ans, score);
	}

}