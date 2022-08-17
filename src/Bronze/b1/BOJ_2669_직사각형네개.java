package Bronze.b1;

import java.util.Scanner;

public class BOJ_2669_직사각형네개 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][101];
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int x = x1; x < x2; x++) { // 면적은 전체 꼭지점-1
				for (int y = y1; y < y2; y++) {
					if (arr[x][y] == 0) {
						arr[x][y] = 1;
						cnt++;
					}
				}
			}

		}
		System.out.println(cnt);
	}

}
