package BOJ0726;

import java.util.Scanner;

public class BOJ_2839_Sugar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int max = N / 5; // 5kg의 최대값
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
