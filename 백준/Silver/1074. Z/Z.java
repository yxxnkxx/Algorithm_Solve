import java.util.Scanner;

public class Main {
	static int cnt;
	static int ans;
	static int[][] map;
	static int row, col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		row = sc.nextInt();
		col = sc.nextInt();

		findZ(0, 0, N);
		System.out.println(ans);
	}

	static void findZ(int r, int c, int size) {
		if (ans != 0)
			return;

		if (r == row && c == col && size == 0) {
			ans = cnt;
			return;
		}
		if (size == 0) {
			cnt++;
			return;
		} else {
			// 4개중에 r, c가 위치한 곳 찾기
			int dis = (int) Math.pow(2, size - 1);
			if (row < r + dis && col < c + dis) // 위치가 1
				findZ(r, c, size - 1);

			cnt += dis * dis;
			if (row < r + dis && col >= c + dis) // 2
				findZ(r, c + dis, size - 1);

			cnt += dis * dis;
			if (row >= r + dis && col < c + dis) // 3
				findZ(r + dis, c, size - 1);

			cnt += dis * dis;
			if (row >= r + dis && col >= c + dis)
				findZ(r + dis, c + dis, size - 1);

			cnt += dis * dis;
		}
	}
}