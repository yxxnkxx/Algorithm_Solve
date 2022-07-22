package BOJ0720;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2564_경비원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bx = sc.nextInt();
		int by = sc.nextInt();
		int N = sc.nextInt();
		int[] dirs = { 1, 3, 2, 4 }; // 북 서 남 동
		int[][] shops = new int[N][3]; // 각 배열의 idx 0=x좌표, idx 1=y좌표
		for (int i = 0; i < N; i++) {
			int dir = sc.nextInt();
			shops[i][2] = dir;
			switch (dir) {
			case 1: // 북
				shops[i][0] = sc.nextInt();
				shops[i][1] = 0;
				break;
			case 2: // 남
				shops[i][0] = sc.nextInt();
				shops[i][1] = by;
				break;
			case 3: // 서
				shops[i][0] = 0;
				shops[i][1] = sc.nextInt();
				break;
			case 4: // 동
				shops[i][0] = bx;
				shops[i][1] = sc.nextInt();

			}
		}
		int[] dong = new int[3];
		int dongdir = sc.nextInt();
		dong[2] = dongdir;
		switch (dongdir) {
		case 1: // 북
			dong[0] = sc.nextInt();
			dong[1] = 0;
			break;
		case 2: // 남
			dong[0] = sc.nextInt();
			dong[1] = by;
			break;
		case 3: // 서
			dong[0] = 0;
			dong[1] = sc.nextInt();
			break;
		case 4: // 동
			dong[0] = bx;
			dong[1] = sc.nextInt();
		}

		int sum = 0;
		System.out.println(Arrays.deepToString(shops));
		System.out.println(Arrays.toString(dong));
		for (int i = 0; i < N; i++) {
			// dir이 같으면 절대값 차이 반환
			int dx = Math.abs(dong[0] - shops[i][0]);
			int dy = Math.abs(dong[1] - shops[i][1]);
			if (dongdir == shops[i][2]) {
				sum += dx;
				sum += dy;
			} else {
				// 시계 방향

				// 시계반대방향
			}

			// 다르면 두 방향 중 작은 값 반환
		}

	}

}
