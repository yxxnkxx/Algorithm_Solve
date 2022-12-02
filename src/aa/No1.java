package aa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1 {
 // test
	static int[] dis; // 각 index의 거리를 저장함
	static int[][] pos = new int[3][];
	static int N;
	static int ans;
	static int[][] order;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		order = new int[6][3]; // 순열
		order[0] = new int[] { 0, 1, 2 };
		order[1] = new int[] { 0, 2, 1 };
		order[2] = new int[] { 1, 0, 2 };
		order[3] = new int[] { 1, 2, 0 };
		order[4] = new int[] { 2, 0, 1 };
		order[5] = new int[] { 2, 1, 0 };

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 3600;
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int gate = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				pos[i] = new int[num];
				Arrays.fill(pos[i], gate);

			}
			dis = new int[N + 1]; // 각 낚시꾼의 거리, 0은 안씀

			for (int i = 0; i < 6; i++) {
				find(0, i);
				Arrays.fill(dis, 0);
			}
			System.out.println("#" + t + " " + ans);
		}

	}

	// 마지막 경우에만 가까운 빈자리가 두 곳일 때 두 경우를 비교하기
	static void find(int depth, int o) {
		if (depth == 3) {
			int sum = 0;
			for (int i = 1; i < dis.length; i++)
				sum += dis[i];
			if (sum < ans)
				ans = sum;
			return;
		}

		int[] arr = pos[order[o][depth]];
		int d = 0;
		int gate = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			while (true) {
				if (gate - d > 0 && dis[gate - d] == 0) {
					dis[gate - d] = d + 1;
					break;
				}
				if (gate + d <= N && dis[gate + d] == 0) {
					dis[gate + d] = d + 1;
					break;
				}
				d++;
			}
		}

		// 마지막 경우의 수
		while (true) {
			if (gate - d > 0 && dis[gate - d] == 0 && gate + d <= N && dis[gate + d] == 0) { // 가장 가까운 빈 자리가 두 곳이면
				dis[gate - d] = d + 1;
				int[] tmp = dis.clone();
				find(depth + 1, o); // 왼쪽
				dis = tmp;
				dis[gate - d] = 0;
				dis[gate + d] = d + 1;
				find(depth + 1, o); // 오른쪽
				break;
			} else if (gate - d > 0 && dis[gate - d] == 0) { // 왼쪽
				dis[gate - d] = d + 1;
				find(depth + 1, o);
				break;
			} else if (gate + d <= N && dis[gate + d] == 0) { // 오른쪽
				dis[gate + d] = d + 1;
				find(depth + 1, o);
				break;
			} else
				d++;
		}
	}

}
