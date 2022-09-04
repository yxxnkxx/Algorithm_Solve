import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 1;
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 0)
				break; // a만 0이어도 break해도 됨
			double result = 0;
			String edge = "";

			System.out.println("Triangle #" + cnt++);
			if (a == -1) {
				if (b >= c) {
					System.out.println("Impossible.");
				} else {
					result = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
					System.out.println("a = " + String.format("%.3f", result));
				}
			} else if (b == -1) {
				if (a >= c) {
					System.out.println("Impossible.");
				} else {
					result = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
					System.out.println("b = " + String.format("%.3f", result));
				}
			} else {
				result = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
				System.out.println("c = " + String.format("%.3f", result));

			}
			System.out.println();
		}
	}

}