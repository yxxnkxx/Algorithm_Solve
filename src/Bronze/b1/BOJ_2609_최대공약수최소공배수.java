package Bronze.b1;

import java.util.Scanner;

public class BOJ_2609_최대공약수최소공배수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = gcd(a, b);
		int lcm = a * b / gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}

	static int gcd(int a, int b) {
		if (a % b == 0)
			return b;
		else {
			return gcd(b, a % b);
		}

	}
}
