package Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int N;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map.put(0, 5);
		map.put(5, 0);
		map.put(1, 3);
		map.put(3, 1);
		map.put(2, 4);
		map.put(4, 2); // 마주보는 index끼리 서로를 key와 value로 함

		int[][] dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++)
				dice[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 6; i++) {
			dfs(dice, dice[0][i], 0, 0);
		}
		System.out.println(max);

	}

	static void dfs(int[][] dice, int top, int depth, int sum) {
		if (depth == N) { // 깊이가 N이 되면 계산 완료
			if (sum > max) // max update
				max = sum;
			return;
		}

		// 위 / 아래면 찾기
		int topIdx = 0;
		int bottomIdx = 0;
		for (int d = 0; d < 6; d++) {
			if (dice[depth][d] == top) {
				topIdx = d; // 윗면의 idx 찾기
				bottomIdx = map.get(d); // 윗면과 마주보는 index
			}
		}
		int max = 0;
		for (int d = 0; d < 6; d++) {
			if (d != topIdx && d != bottomIdx) {
				max = Math.max(max, dice[depth][d]);
			}
		} // 옆면 중 최대값 찾아서 더하기

		sum += max;
		// top은 이전 dice의 bottom값
		dfs(dice, dice[depth][bottomIdx], depth + 1, sum);

	}

}
