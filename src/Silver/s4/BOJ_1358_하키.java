package Silver.s4;

import java.util.Scanner;

public class BOJ_1358_하키 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int P = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < P; i++) {
			int px = sc.nextInt();
			int py = sc.nextInt();

			// 사각형
			if (px >= X && px <= X + W && py >= Y && py <= Y + H)
				cnt++;
			// 원
			else {
				int circleY = Y + (H / 2); // 원 중심의 y 좌표
				// 왼쪽 원
				int disLeft = (int) (Math.pow(X - px, 2) + Math.pow(circleY - py, 2));
				int disRight = (int) (Math.pow((X + W) - px, 2) + Math.pow(circleY - py, 2));

				if (disLeft <= (int) Math.pow(circleY - Y, 2))
					cnt++;
				// 오른쪽 원
				else if (disRight <= (int) Math.pow(circleY - Y, 2))
					cnt++;
			}

		}
		System.out.println(cnt);
	}

}
