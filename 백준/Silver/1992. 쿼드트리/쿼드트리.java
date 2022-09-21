import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		dc(N, 0, 0);
		System.out.println(sb);
	}

	static void dc(int N, int r, int c) {
		if (N == 1) {
			sb.append(map[r][c]);
			return;
		}

		boolean check = true;
		char color = map[r][c];
		label: for (int i = r; i < r + N; i++)
			for (int j = c; j < c + N; j++) {
				if (map[i][j] != color) {
					check = false;
					break label;
				}
			}

		if (check) {
			sb.append(map[r][c]);
			return;
		}
		sb.append('(');
		dc(N / 2, r, c);
		dc(N / 2, r, c + N / 2);
		dc(N / 2, r + N / 2, c);
		dc(N / 2, r + N / 2, c + N / 2);
		sb.append(')');

	}
}