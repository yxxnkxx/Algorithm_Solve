package Silver.s5;

import java.util.Scanner;

public class BOJ_1789_수들의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int cnt = 0;
		while (N > cnt) {
			N -= cnt + 1;
			cnt++;
		}
		System.out.println(cnt);
	}

}
