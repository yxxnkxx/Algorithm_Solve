package BOJ.Silver.s4;

import java.util.Scanner;

public class BOJ_3036_링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int f = sc.nextInt();
		for (int i = 1; i < N; i++) {
			int first = f;
			int n = sc.nextInt();
			int next = n;
			while (next != 0) {
				int tmp = first % next;
				first = next;
				next = tmp;
			}
			System.out.println((f / first) + "/" + (n / first));
		}
	}

}
