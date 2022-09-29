package SWEA.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]); // int배열에 저장
				}
			}

			int mid = N / 2;

			int sum = 0;

			for (int r = 0; r < N; r++) {
				int distance = Math.abs(r - mid); // mid와 r의 차이
				int start = distance; // 거리가 0이면 처음부터, 거리가 1이면 1부터 시작
				int end = mid + (mid - distance); // mid에서 mid와 distance의 차이만큼 더한 곳이 끝
				for (int c = start; c <= end; c++) {
					sum += arr[r][c];
				}
			}
			System.out.printf("#%d %d\n", t + 1, sum);

		}

	}
}
