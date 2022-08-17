package Silver.s5;

import java.util.Scanner;

public class BOJ_1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int num = 665;
		while (cnt < N) {
			num++;
			String str = Integer.toString(num);
			if (str.contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);

	}

}
