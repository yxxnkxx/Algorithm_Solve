package Bronze.b2;

import java.util.Scanner;

public class BOJ_6322_직각삼각형두변 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int cnt = 1;
		while (a != 0) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			double result = 0;
			String edge = "";
			System.out.println("Triangle #" + cnt++);
			if (a == -1) {
				result = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
				edge = "a";
			} else if (b == -1) {
				result = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
				edge = "b";
			} else {
				result = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
				edge = "c";
			}
			if (Double.isNaN(result)) {
				System.out.println("Impossible.");
			} else {
				System.out.printf("%s = %.3f\n", edge, result);
			}
			System.out.println();
			a = sc.nextInt();
		}
	}

}
