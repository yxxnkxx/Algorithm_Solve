package SWEA.d3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6485_삼성시의버스노선 {
	static int count[] = new int[5001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			Arrays.fill(count, 0);
			int N = sc.nextInt(); // 버스 노선의 개수
			for (int n = 0; n < N; n++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				for (int i = a; i <= b; i++)
					count[i]++;
			}

			sb.append("#" + (t + 1) + " ");
			int P = sc.nextInt(); // 버스 정류장의 개수
			for (int p = 0; p < P; p++) {
				int c = sc.nextInt();
				sb.append(count[c] + " ");
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

}
