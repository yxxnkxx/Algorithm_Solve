package Silver.s3;

import java.util.Scanner;

public class BOJ_1004_어린왕자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int N = sc.nextInt();
			// 거리가 반지름 안에 있으면 cnt++
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt();

				int dis1 = (int) (Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));
				int dis2 = (int) (Math.pow(cx - x2, 2) + Math.pow(cy - y2, 2));
				if (dis1 < r * r && dis2 > r * r) {
					cnt++;

				}
				if (dis2 < r * r && dis1 > r * r) {
					cnt++;
				}

			} // 행성 정보 입력
			System.out.println(cnt);

		}

	}

}
