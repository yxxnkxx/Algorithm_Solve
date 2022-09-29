package SWEA.d3;

import java.util.Scanner;

public class SWEA_5789_상자바꾸기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N + 1]; // 1부터 N까지 사용
			int Q = sc.nextInt();
			for (int i = 1; i <= Q; i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				for (int j = L; j <= R; j++) {
					arr[j] = i;
				}

			}
			System.out.print("#" + (t + 1) + " ");
			for (int i = 1; i <= N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}
	}

}
