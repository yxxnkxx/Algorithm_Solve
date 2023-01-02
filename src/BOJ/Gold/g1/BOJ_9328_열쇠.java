package BOJ.Gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9328_열쇠 {
    static class Door {
        int idx; // 알파벳 순서
        int r;
        int c;

        public Door(int idx, int r, int c) {
            this.idx = idx;
            this.r = r;
            this.c = c;

        }

    }

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int ans;
    static boolean[] key;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static List<Door> doors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M]; // 방문 표시
            ans = 0;
            key = new boolean[26];
            doors = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] >= 'a' && map[i][j] <= 'z' && (i == 0 || j == 0 || i == N - 1 || j == M - 1))
                        key[map[i][j] - 'a'] = true; // 가장 자리 처리
                    if (map[i][j] >= 'A' && map[i][j] <= 'Z')
                        doors.add(new Door(map[i][j] - 'A', i, j));
                }
            }

            String keys = br.readLine();
            if (!keys.equals("0")) {
                int length = keys.length();
                for (int i = 0; i < length; i++) {
                    int val = keys.charAt(i) - 'a';
                    if (!key[val]) {
                        key[keys.charAt(i) - 'a'] = true;
                    }
                }
            }

            Queue<int[]> doorQueue = new LinkedList<>();

            // 가장자리에서 입구에 추가될 수 있는 것 추가하기
            for (int i = 0; i < N; i++) {
                if (map[i][0] == '.' || map[i][0] == '$' || (map[i][0] >= 'a' && map[i][0] <= 'z')) {
                    doorQueue.add(new int[]{i, 0});
                }
                if (map[i][M - 1] == '.' || map[i][M - 1] == '$' || (map[i][M - 1] >= 'a' && map[i][M - 1] <= 'z')) {
                    doorQueue.add(new int[]{i, M - 1});
                }
            }
            for (int j = 0; j < M; j++) {
                if (map[0][j] == '.' || map[0][j] == '$' || (map[0][j] >= 'a' && map[0][j] <= 'z')) {
                    // 빈 공간이거나, 문서이거나, 열쇠이거나, 문인데 열쇠가 있거나
                    doorQueue.add(new int[]{0, j});
                }
                if (map[N - 1][j] == '.' || map[N - 1][j] == '$' || (map[N - 1][j] >= 'a' && map[N - 1][j] <= 'z')) {
                    // 빈 공간이거나, 문서이거나, 열쇠이거나, 문인데 열쇠가 있거나
                    doorQueue.add(new int[]{N - 1, j});
                }

            }

            // 문 차례로 열기
            for (Door door : doors) {
                if (key[door.idx]) {
                    // 문이면 인접한 곳 중에서 이미 방문한 곳이 있을 때만  queue에 추가함
                    if (checkDoor(door.r, door.c))
                        doorQueue.add(new int[]{door.r, door.c}); //
                }
            }

            while (!doorQueue.isEmpty()) {
                int[] arr = doorQueue.poll();
                int r = arr[0];
                int c = arr[1];
                if (visited[r][c]) continue;
                visited[r][c] = true;
                if (map[r][c] >= 'A' && map[r][c] <= 'Z') {
                    for (Door d : doors) // 문 리스트에서 제거하기
                        if (d.r == r && d.c == c) {
                            doors.remove(d);
                            break;
                        }
                }

                if (map[r][c] >= 'a' && map[r][c] <= 'z') { // 열쇠
                    key[map[r][c] - 'a'] = true;
                    for (Door tmp : doors) { // 열 수 있는 문을 연다
                        if (!visited[tmp.r][tmp.c] && tmp.idx == map[r][c] - 'a' && checkDoor(tmp.r, tmp.c)) {
                            doorQueue.add(new int[]{tmp.r, tmp.c});
                        }
                    }
                }


                if (map[r][c] == '$') {
                    ans++;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != '*' && !visited[nr][nc]) {
                        if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z' || map[nr][nc] == '$' || map[nr][nc] == '.') { // 열쇠, 빈 공간, 문서
                            doorQueue.add(new int[]{nr, nc});
                        } else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') // 문
                            if (key[map[nr][nc] - 'A']) { // 열 수 있는 경우에만
                                doorQueue.add(new int[]{nr, nc});
                            }
                    }
                }
            }
            sb.append(ans).append("\n");

        }
        System.out.print(sb);
    }

    static boolean checkDoor(int r, int c) {
        if (r == 0 || r == N - 1 || c == 0 || c == M - 1) return true; // 가장자리는 무조건 가능
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc])
                return true;
        }

        return false;

    }
}

