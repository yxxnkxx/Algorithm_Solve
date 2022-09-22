package Silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주 {
	static int beer;
	static List<int[]> conv;
	static boolean[] visited;
	static int fr, fc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			beer = 20;
			conv = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			// 편의점 방문 여부

			// 상근이네 집
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sangR = Integer.parseInt(st.nextToken());
			int sangC = Integer.parseInt(st.nextToken());

			// 편의점
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				conv.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}
			// 락페스티벌 좌표
			st = new StringTokenizer(br.readLine());
			fr = Integer.parseInt(st.nextToken());
			fc = Integer.parseInt(st.nextToken());

			// 입력
			bfs(sangR, sangC);

		}
	}

	static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sr, sc });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			if (Math.abs(tmp[0] - fr) + Math.abs(tmp[1] - fc) <= 1000) {
				System.out.println("happy");
				return;
			}

			for (int i = 0; i < conv.size(); i++) {
				if (!visited[i]) {
					int cr = conv.get(i)[0];
					int cc = conv.get(i)[1];
					if (Math.abs(tmp[0] - cr) + Math.abs(tmp[1] - cc) <= 1000) {
						visited[i] = true;
						queue.add(conv.get(i));
					}
				}
			}
		}
		System.out.println("sad");

	}

}
