package BOJ.Silver.s5;

import java.util.Scanner;

public class BOJ_2869_Snail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int day = 0;

		day = (V - B) / (A - B);
		if ((V - B) % (A - B) != 0) {
			day++;
		}
		System.out.println(day);

	}

}
