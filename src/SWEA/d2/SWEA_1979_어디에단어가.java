package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979_어디에단어가 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] length = br.readLine().split(" ");
			int N = Integer.parseInt(length[0]);
			int K = Integer.parseInt(length[1]);
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());

					arr[i][j] = num;
				}
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				int isOne = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) { // row 검사
						isOne++;
					} else {
						if (isOne == K) {
							count++; // isOne이 K가 되면 count++
						}
						isOne = 0; // 초기화
					}
				}
				if (isOne == K) {
					count++;
				}

			}
			for (int i = 0; i < N; i++) {
				int isOne = 0;
				for (int j = 0; j < N; j++) {
					if (arr[j][i] == 1) { // col 검사
						isOne++;
					} else {
						if (isOne == K) {
							count++;
						}
						isOne = 0;
					}
				}
				if (isOne == K) {
					count++;
				}

			}
			System.out.println("#" + (t + 1) + " " + count);
		}

	}
}
