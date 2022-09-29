package SWEA.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315_오목판정 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++)
				arr[i] = br.readLine().toCharArray();
			// 입력

			System.out.println("#" + t + " " + check(arr));
		}
	}

	static String check(char[][] arr) {
		int[] row = new int[N];
		int[] col = new int[N];

		// 가로 세로
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'o') {
					row[i]++;
					col[j]++;
				} else {
					row[i] = 0;
					col[j] = 0;
				}

				if (row[i] == 5 || col[j] == 5)
					return "YES";
			}

		// 대각선 왼쪽 위부터
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int d = 0; d < 5; d++) {
					int nr = i + d;
					int nc = j + d;
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 'o')
						sum++;
					else
						break;
					if (sum == 5)
						return "YES";
				}
			}
		// 대각선 오른쪽 위부터
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int d = 0; d < 5; d++) {
					int nr = i + d;
					int nc = j - d;
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 'o')
						sum++;
					else
						break;
					if (sum == 5)
						return "YES";
				}
			}

		return "NO";
	}

}
