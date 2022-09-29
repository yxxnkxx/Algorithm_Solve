package BOJ.Silver.s1;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int cnt;
	static int ans;
	static int[][] map;
	static int row, col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		row = sc.nextInt();
		col = sc.nextInt();

		findZ(0, 0, (int) (Math.pow(2, N)));
		System.out.println(ans);
	}

	static void findZ(int r, int c, int size) {

		if (r == row && c == col && size == 1) {
			ans = cnt;
			return;
		}
		if (size == 1) {
			cnt++;
			return;
		} else {
			// 4개중에 r, c가 위치한 곳 찾기
			int dis = size / 2;
			if (row < r + dis && col < c + dis) // 위치가 1
				findZ(r, c, dis);

			cnt += dis * dis;
			if (row < r + dis && col >= c + dis) // 2
				findZ(r, c + dis, dis);

			cnt += dis * dis;
			if (row >= r + dis && col < c + dis) // 3
				findZ(r + dis, c, dis);

			cnt += dis * dis;
			if (row >= r + dis && col >= c + dis)
				findZ(r + dis, c + dis, dis);
			cnt += dis * dis;
		}
	}
}