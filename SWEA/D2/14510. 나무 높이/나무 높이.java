import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] tree;
	static int max;
	static int ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());

			}
			Arrays.sort(tree);
			max = tree[N - 1];
			// 처음에 모두 같은지 검사 한 번 하기

			boolean check = true;
			for (int i = 0; i < N; i++) {
				if (tree[i] < max)
					check = false;
			}
			if (check) {
				sb.append("#" + t + " 0").append("\n");
				continue;
			}

			bfs();
			sb.append("#" + t + " " + ans).append("\n");

		}
		System.out.print(sb);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>(); // q를 돌면서 모든 나무가 max가 되면 종료하기
		// q는 크기가 N+1, tree배열 +며칠이 지났는지 체크
		// day가 홀수면 0,1 day가 짝수면 0,2 증가시키기
		int[] tmp = new int[N + 1];
		for (int i = 0; i < N; i++)
			tmp[i] = tree[i];

		q.add(tmp);
		label: while (!q.isEmpty()) {
			int[] curr = q.poll();
			curr[N] += 1; // 하루 증가 후 물 주기
			boolean check = true;
			boolean pass = false; // 그 날을 넘길건지 말건지
			for (int i = N - 1; i >= 0; i--) {
				if (curr[i] < max) {
					check = false; // 아직 모든 나무에 물주기가 완료되지 않음
					// 짝수 홀수 검사해서 q에 넣기
					if (curr[N] % 2 == 0) {
						if (max - curr[i] == 1) // 짝수 날인데 차이가 1이면 기다리기
							pass = true;
						// pass는 모든 값이 해당 경우의 수일 때만 사용, 아니면 메모리 낭비임
						else {
							int[] newarr2 = curr.clone();
							newarr2[i] += 2;
							q.add(newarr2); // 2증가
							pass = false;
							continue label; // 하나 추가하면 다른 나무는 검사할 필요 없음
						}
					} else {
						if (max - curr[i] == 2) // 홀수 날인데 차이가 2이면 기다리기
							pass = true;
						// 홀수
						else {
							int[] newarr1 = curr.clone();
							newarr1[i] += 1; // 1증가
							q.add(newarr1);
							pass = false;
							continue label;
						}
					}

				}
			}

			if (check) { // 모든 나무가 max 이상
				ans = curr[N] - 1; // 일단 큐에 넣고 다음에 검사하니깐
				break;
			}
			// 마지막까지 왔는데 pass가 true라면? 아무것도 하지 않고 1일 넘기기
			if (pass) {
				q.add(curr.clone());
			}
		}

	}
}