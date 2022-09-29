package BOJ.Silver.s4;

import java.util.Scanner;

public class BOJ_2839_Sugar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int max = N / 5; // 5kg 사용 개수의 최대개수
		int ans = -1;
		for (int i = 0; i <= max; i++) {
			if ((N - i * 5) % 3 == 0) { // 나머지가 딱 떨어짐
				int cnt = i + ((N - i * 5) / 3);
				if (ans == -1 || cnt < ans) {
					ans = cnt;
				}
			}
		}

		System.out.println(ans);
	}

}
