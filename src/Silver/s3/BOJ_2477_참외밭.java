package Silver.s3;

import java.util.Scanner;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int maxX = 0;
		int maxY = 0;
		int[][] arr = new int[6][2];
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int data = sc.nextInt();
			arr[i] = new int[] { dir, data };
			switch (dir) {
			case 1:
			case 2:
				maxX = Math.max(maxX, data);
				break;
			case 3:
			case 4:
				maxY = Math.max(maxY, data);
				break;
			}
		}
		int area = maxX * maxY;
		int minY = 0;
		int minX = 0;
		for (int i = 0; i < 6; i++) {
			int prev = (i - 1 + 6) % 6;
			int next = (i + 1 + 6) % 6;
			if (arr[prev][0] == arr[next][0]) {
				if (arr[i][0] == 1 || arr[i][0] == 2)
					minX = arr[i][1];
				else {
					minY = arr[i][1];
				}
			}
		}
		area -= minX * minY;
		System.out.println(area * K);

	}

}
