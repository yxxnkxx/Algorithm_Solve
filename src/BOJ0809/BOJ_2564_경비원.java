package BOJ0809;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2564_경비원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bx = sc.nextInt(); // 가로
		int by = sc.nextInt(); // 세로
		int N = sc.nextInt();
		ArrayList<int[]> arr = new ArrayList<>(); // shop의 위치와 방향을 담을 배열

		// 가상의 이차원 배열을 상상, 왼쪽 위가 0,0
		// 북, 남은 col이 변함
		// 동, 서는 row가 변함
		for (int i = 0; i < N; i++) {
			int row = 0;
			int col = 0;
			int dir = sc.nextInt();
			switch (dir) {
			case 1: // 북
				row = 0;
				col = sc.nextInt();
				break;
			case 2: // 남
				row = by; // box의 세로 길이
				col = sc.nextInt();
				break;
			case 3: // 서
				row = sc.nextInt();
				col = 0;
				break;
			case 4: // 동
				row = sc.nextInt();
				col = bx; // box의 가로 길이
				break;
			}
			arr.add(new int[] { row, col, dir });
		}

		int dongdir = sc.nextInt();
		int dongr = 0;
		int dongc = 0;
		switch (dongdir) {
		case 1: // 북
			dongr = 0;
			dongc = sc.nextInt();
			break;
		case 2: // 남
			dongr = by;
			dongc = sc.nextInt();
			break;
		case 3: // 서
			dongr = sc.nextInt();
			dongc = 0;
			break;
		case 4: // 동
			dongr = sc.nextInt();
			dongc = bx;
			break;
		}

		int sum = 0;
		for (int[] shop : arr) {
			if (dongdir + shop[2] == 3 || dongdir + shop[2] == 7) {
				// 서로 마주보는 경우 180도 차이
				// dong이 남이나 북에 있을 경우
				if (dongdir == 1 || dongdir == 2) {
					sum += Math.min(dongc + shop[1], 2 * bx - (dongc + shop[1]));
					sum += by;
				} else {
					// dong이 동이나 서에 있을 경우
					sum += bx;
					sum += Math.min(dongr + shop[0], 2 * by - (dongr + shop[0]));
				}

			} else {
				// 90도 차이 : 두 좌표의 절댓값차이
				// 같은 줄에 있을 대도 절댓값 차이
				sum += Math.abs(shop[0] - dongr);
				sum += Math.abs(shop[1] - dongc);
			}

		}
		System.out.println(sum);

	}

}
