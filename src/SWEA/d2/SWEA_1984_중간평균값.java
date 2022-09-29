package SWEA.d2;

import java.util.Scanner;

public class SWEA_1984_중간평균값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int min = 10000;
			int max = 0;
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int k = sc.nextInt();
				sum += k;
				if (k < min)
					min = k;
				if (k > max)
					max = k;
			}
			long result = Math.round((double) (sum - max - min) / 8);

			System.out.println("#" + (t + 1) + " " + result);

		}
	}

}
