package SWEA.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_1873_상호배틀 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		HashMap<Character, Integer[]> dir = new HashMap<>();
		// 각 방향의 dr dc
		dir.put('<', new Integer[] { 0, -1 });
		dir.put('>', new Integer[] { 0, 1 });
		dir.put('^', new Integer[] { -1, 0 });
		dir.put('v', new Integer[] { 1, 0 });
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int r = 0; // 전차 좌표
			int c = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // row
			int W = Integer.parseInt(st.nextToken()); // col
			char[][] map = new char[H][W];
			for (int h = 0; h < H; h++) {
				String str = br.readLine();
				for (int w = 0; w < W; w++) {
					map[h][w] = str.charAt(w);
					if (dir.containsKey(str.charAt(w))) {
						r = h;
						c = w;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();
			for (int i = 0; i < N; i++) {
				char com = command.charAt(i);
				switch (com) {
				case 'U':
					if (r - 1 >= 0 && map[r - 1][c] == '.') { // 위칸이 평지라면
						map[r][c] = '.'; // 자기가 있던 칸은 평지로 만들기
						map[r - 1][c] = '^'; // 위 칸으로 이동
						r--; // 좌표 변경
					} else
						map[r][c] = '^'; // 아니라면 이동x
					break;
				case 'D':
					if (r + 1 < H && map[r + 1][c] == '.') { // 아래칸이 평지라면
						map[r][c] = '.'; // 자기가 있던 칸은 평지로 만들기
						map[r + 1][c] = 'v'; // 아래칸으로 이동
						r++; // 좌표 변경
					} else
						map[r][c] = 'v'; // 아니라면 이동x
					break;
				case 'L':
					if (c - 1 >= 0 && map[r][c - 1] == '.') { // 왼쪽칸이 평지라면
						map[r][c] = '.'; // 자기가 있던 칸은 평지로 만들기
						map[r][c - 1] = '<'; // 왼쪽칸으로 이동
						c--; // 좌표 변경
					} else
						map[r][c] = '<'; // 아니라면 이동x
					break;
				case 'R':
					if (c + 1 < W && map[r][c + 1] == '.') { // 오른쪽칸이 평지라면
						map[r][c] = '.'; // 자기가 있던 칸은 평지로 만들기
						map[r][c + 1] = '>'; // 오른쪽칸으로 이동
						c++; // 좌표 변경
					} else
						map[r][c] = '>'; // 아니라면 이동x
					break;
				case 'S':
					int dr = dir.get(map[r][c])[0]; // 해당 방향의 dr
					int dc = dir.get(map[r][c])[1]; // 해당 방향의 dc
					int nr = r + dr;
					int nc = c + dc;
					while (nr >= 0 && nr < H && nc >= 0 && nc < W) { // 맵 안에 있음
						if (map[nr][nc] == '*') { // 벽돌로 만든 벽
							map[nr][nc] = '.'; // 벽돌이 포탄 -> 평지가 됨
							break;
						} else if (map[nr][nc] == '#') // 강철로 만든 벽
							break; // 그냥 소멸함
						nr += dr;
						nc += dc;
					}

					break;
				}
			}

			sb.append("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

		} // tc

		System.out.print(sb.toString());
	} // main

}
