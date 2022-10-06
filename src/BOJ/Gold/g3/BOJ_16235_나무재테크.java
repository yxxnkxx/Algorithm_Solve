package BOJ.Gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static int N, M, K;
	static int[][] map;
	static int[][] A;
	static List<int[]> trees;
	static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		trees = new ArrayList<>();

		// 초기 양분은 5로 채워짐
		for (int i = 1; i <= N; i++)
			Arrays.fill(map[i], 5);

		A = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		} // 입력

		// 나무 나이 입력하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees.add(new int[] { r, c, age });
		}

		for (int k = 0; k < K; k++) {
			int[][] tmp = new int[N + 1][N + 1];

			// 봄
			Collections.sort(trees, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
//					if (o1[0] == o2[0]) {
//						if (o1[1] == o2[1]) {
//							return o1[2] - o2[2];
//						}
//						return o1[1] - o2[1];
//					}
					return o1[2] - o2[2];
				}
			});
			for (int i = 0; i < trees.size(); i++)
				System.out.println(trees.get(i)[0] + " " + trees.get(i)[1] + " " + trees.get(i)[2]);

			System.out.println("2 2 " + map[2][2]);
			for (int i = 0; i < trees.size(); i++) {
				int r = trees.get(i)[0];
				int c = trees.get(i)[1];
				int age = trees.get(i)[2];
//				System.out.println(r + " " + c + " " + age);

				if (map[r][c] >= age) {
					trees.get(i)[2] += 1;
					map[r][c] -= age;
				} else {
					tmp[r][c] += age / 2;
					trees.remove(i);
				}

			}
			// 여름
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					map[i][j] += tmp[i][j];
				}

			// 가을 번식
			for (int i = 0; i < trees.size(); i++) {
				int r = trees.get(i)[0];
				int c = trees.get(i)[1];
				int age = trees.get(i)[2];
				if (age % 5 == 0) {
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr > 0 && nr <= N && nc > 0 && nc <= N) {
							trees.add(new int[] { nr, nc, 1 });
						}
					}
				}
			}

			// 겨울 양분 추가
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					map[i][j] += A[i][j];
				}
			System.out.println("--");
			for (int i = 1; i <= N; i++)
				System.out.println(Arrays.toString(map[i]));

		}
		System.out.println(trees.size());
	}

}
