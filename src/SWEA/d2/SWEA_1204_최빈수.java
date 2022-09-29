package SWEA.d2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1204_최빈수 {
	static int[] count = new int[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			Arrays.fill(count, 0);
			int N = sc.nextInt();
			for (int i = 0; i < 1000; i++) {
				count[sc.nextInt()]++;
			}

			int max = 0;
			int idx = 0;
			for (int i = 100; i >= 0; i--) {
				if (count[i] > max) {
					max = count[i];
					idx = i;
				}
			}
			System.out.println("#" + N + " " + idx);

		}
	}

}
