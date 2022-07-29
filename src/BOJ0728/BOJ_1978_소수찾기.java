package BOJ0728;

import java.util.Scanner;

public class BOJ_1978_소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		label: for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 1)
				continue;
			else {
				for (int j = 2; j < num; j++) {
					if (num % j == 0) {
						continue label;
					}
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
