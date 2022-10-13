
import java.util.Scanner;

public class Main {

	static int[][] map = new int[10][10];
	static boolean[][] visited = new boolean[10][10];
	static int[] confetti = { 0, 5, 5, 5, 5, 5 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				map[i][j] = sc.nextInt();
		put(0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);

	}

	static void put(int cnt) {

		boolean check = true;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					check = false;
					break;
				}
			}

		if (check) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (cnt >= ans)
			return;

		// 5부터 가능한지 검사하기
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					for (int c = 5; c > 0; c--)
						if (check(i, j, c)) {
							if (confetti[c] == 0)
								continue;
							confetti[c]--;
							color(i, j, c);
							put(cnt + 1);
							confetti[c]++;
							color(i, j, c); // 원상 복구하기
						}
					return;

				}

			}
	}

	static boolean check(int i, int j, int size) {
		for (int r = i; r < i + size; r++) {
			for (int c = j; c < j + size; c++) {
				if (r >= 10 || c >= 10 || map[r][c] == 0 || visited[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

	static void color(int i, int j, int size) {
		for (int r = i; r < i + size; r++) {
			for (int c = j; c < j + size; c++) {
				map[r][c] = (map[r][c] + 1) % 2;
			}
		}
	}

}
