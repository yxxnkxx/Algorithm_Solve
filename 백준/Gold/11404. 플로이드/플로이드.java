import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			Arrays.fill(map[i], 10000001);
		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			map[st][ed] = Math.min(map[st][ed], w);
		}
		for (int k = 1; k <= N; k++)
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			map[i][i] = 0;
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 10000001)
					map[i][j] = 0;
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}