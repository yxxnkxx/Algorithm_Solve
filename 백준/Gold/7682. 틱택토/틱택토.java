
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String input = br.readLine();
			if (input.equals("end"))
				break;
			map = new char[3][3];
			int cntO = 0;
			int cntX = 0;
			int empty = 0;
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++) {
					map[i][j] = input.charAt(i * 3 + j);
					switch (map[i][j]) {
					case 'O':
						cntO++;
						break;
					case 'X':
						cntX++;
						break;
					case '.':
						empty++;
						break;
					}
				}
			boolean isO = check('O');
			boolean isX = check('X');

			// empty - 조건을 충족했는지 체크
			if (empty == 0) {
				// full
				if (!isO && cntO + 1 == cntX)
					sb.append("valid").append("\n");
				else
					sb.append("invalid").append("\n");

			} else {
				// empty
				if (isO && !isX && cntO == cntX)
					sb.append("valid").append("\n");
				else if (!isO && isX && cntO + 1 == cntX)
					sb.append("valid").append("\n");

				else
					sb.append("invalid").append("\n");
			}
		}
		System.out.print(sb);
	}

	static boolean check(char c) {
		for (int i = 0; i < 3; i++) {
			if (map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
				return true;
			}
			if (map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
				return true;
			}
		}

		// 대각선 검사
		if (map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
			return true;
		}
		if (map[0][2] == c && map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
			return true;
		}
		return false;
	}

}
