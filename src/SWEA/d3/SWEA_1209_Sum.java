package SWEA.d3;

import java.util.Scanner;

public class SWEA_1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		for (int t = 0; t < 10; t++) {
			int T = sc.nextInt();
			int sum = 0;
			int[] colsum = new int[100]; // 각 col의 합
			for (int i = 0; i < 100; i++) {
				int tmprow = 0;
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					tmprow += arr[i][j];
					colsum[j] += arr[i][j];
				}
				if (sum < tmprow)
					sum = tmprow; // 열의 합
			}
			for (int col : colsum) {
				if (sum < col)
					sum = col;
			}

			// 대각선
			int left = 0; // 왼쪽 위에서 시작
			int right = 0; // 오른쪽 위에서 시작
			for (int i = 0; i < 100; i++) {
				left += arr[i][i];
				right += arr[i][99 - i];
			}
			if (sum < left)
				sum = left;
			if (sum < right)
				sum = right;

			System.out.println("#" + (t + 1) + " " + sum);
		}
	}

}
