package Silver.s1;

import java.util.Scanner;

public class BOJ_2527_직사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		for (int i = 0; i < 4; i++) {
			result = "d";
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			int x4 = sc.nextInt();
			int y4 = sc.nextInt();

			// d부터 체크
			if (x2 < x3 || y2 < y3 || x4 < x1 || y4 < y1)
				result = "d";
			else if ((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) || (x2 == x3 && y2 == y3)
					|| (x2 == x3 && y1 == y4))
				result = "c";
			else if (x1 == x4 || x2 == x3 || y1 == y4 || y2 == y3)
				result = "b";
			else {
				result = "a";
			}

			System.out.println(result);
		}
	}
}
