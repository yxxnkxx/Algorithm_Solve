package BOJ.Silver.s5;

import java.util.Scanner;

public class BOJ_1676_팩토리얼0의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt2 = 0;
		int cnt5 = 0;
		for (int i = 2; i <= N; i++) {
			// 2의 개수
			int tmp = i;
			while (tmp % 2 == 0) {
				cnt2++;
				tmp /= 2;
			}

			// 5의 개수
			while (tmp % 5 == 0) {
				cnt5++;
				tmp /= 5;
			}

		}
		System.out.println(Math.min(cnt2, cnt5));
	}

}
