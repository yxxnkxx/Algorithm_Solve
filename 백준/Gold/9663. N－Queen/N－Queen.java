import java.util.Scanner;

public class Main {

	static int[] queen; // index는 row 좌표, col은 index의 값
	static int N;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int[N];
		dfs(0);
		System.out.println(cnt);

	}

	static void dfs(int row) {
		if (row == N) {
			cnt++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (check(row, col)) {
				queen[row] = col;
				dfs(row + 1);
				queen[row] = 0;
			}
		}
	}

	static boolean check(int row, int col) {
		for (int r = 0; r < row; r++) {
			if (queen[r] == col)
				return false;
			if (Math.abs(queen[r] - col) == Math.abs(r - row))
				return false;
		}
		return true;

	}
}