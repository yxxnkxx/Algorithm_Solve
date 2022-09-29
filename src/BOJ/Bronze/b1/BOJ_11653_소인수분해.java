package BOJ.Bronze.b1;

import java.util.Scanner;

public class BOJ_11653_소인수분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = 2;
		while (N > 1) {
			if (N % d == 0) {
				N /= d;
				System.out.println(d);
			} else {
				d += 1;
			}
		}

	}

}
