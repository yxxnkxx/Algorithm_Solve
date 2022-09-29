package SWEA.d3;

import java.util.Scanner;

public class SWEA_1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++)
				arr[i] = sc.next().toCharArray();

			int cnt = 0;
			// 가로 검사
			boolean check = true;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - N; j++) {
					int start = j;
					int end = j + N - 1;
					while (start <= end) {
						if (arr[i][start] == arr[i][end]) {
							start++;
							end--;
						} else {
							check = false;
							break;
						}

					}
					if (check)
						cnt++;
					check = true;
				}
			}

			// 세로 검사
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i <= 8 - N; i++) {
					int start = i;
					int end = i + N - 1;
					while (start <= end) {
						if (arr[start][j] == arr[end][j]) {
							start++;
							end--;
						} else {
							check = false;
							break;
						}

					}
					if (check)
						cnt++;
					check = true;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
