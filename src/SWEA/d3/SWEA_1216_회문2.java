package SWEA.d3;

import java.util.Scanner;

public class SWEA_1216_회문2 {

	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			arr = new char[100][100];
			for (int i = 0; i < 100; i++)
				arr[i] = sc.next().toCharArray();

			int length = 0;
			// row
			for (int i = 0; i < 100; i++) {
				for (int j = 1; j < 100; j++) {
					int idx = 1;
					int tmp;
					if (arr[i][j] == arr[i][j - 1]) { // 짝수
						tmp = 2;
						while (j - 1 - idx >= 0 && j + idx < 100) {
							if (arr[i][j - 1 - idx] == arr[i][j + idx]) { // j를 가운데로 하는 최대 string 길이 찾기
								tmp += 2;
								idx++;
							} else {
								break;
							}
						}
					} else {
						tmp = 1; // 홀수
						while (j - idx >= 0 && j + idx < 100) {
							if (arr[i][j - idx] == arr[i][j + idx]) { // j를 가운데로 하는 최대 string 길이 찾기
								tmp += 2;
								idx++;
							} else {
								break;
							}
						}

					}
					if (length < tmp) // 최댓값 찾기
						length = tmp;
				}
			}
			// col
			for (int i = 1; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					int tmp = 1;
					int idx = 1;
					if (arr[i][j] == arr[i - 1][j]) {
						tmp = 2;
						while (i - 1 - idx >= 0 && i + idx < 100) {
							if (arr[i - 1 - idx][j] == arr[i + idx][j]) {
								tmp += 2;
								idx++;
							} else {
								break;
							}
						}

					} else {

						while (i - idx >= 0 && i + idx < 100) {
							if (arr[i - idx][j] == arr[i + idx][j]) {
								tmp += 2;
								idx++;
							} else {
								break;
							}
						}
					}
					if (length < tmp)
						length = tmp;
				}
			}

			System.out.println("#" + N + " " + length);

		}

	}

}
