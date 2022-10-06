import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++)
			for (int c = 0; c < M; c++)
				map[r][c] = sc.nextInt();
		for (int r = 0; r < N; r++)
			for (int c = 0; c < M; c++) {
				if (r > 0 && c > 0)
					map[r][c] += Math.max(map[r][c - 1], Math.max(map[r - 1][c], map[r - 1][c - 1]));
				else if (r > 0)
					map[r][c] += map[r - 1][c];
				else if (c > 0)
					map[r][c] += map[r][c - 1];
			}
		System.out.println(map[N - 1][M - 1]);

	}

}