package SWEA.d2;

import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int tc = sc.nextInt();
			int[] scores = new int[101];
			for (int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				scores[score]++;
			}

			int max = 0;
			int idx = 0;
			for (int i = 0; i < 101; i++) {
				if (scores[i] >= max) {
					max = scores[i];
					idx = i;
				}
			}

			System.out.println("#" + tc + " " + idx);
		}
	}

}
