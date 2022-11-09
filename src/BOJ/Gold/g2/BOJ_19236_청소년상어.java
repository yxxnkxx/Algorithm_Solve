package BOJ.Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19236_청소년상어 {
    static int N = 4;
    static int[][] map;
    static int[][] fishList = new int[16][4]; // r, c, dir, num
    static boolean[] removed = new boolean[17];
    static int[] shark = new int[4];
    static int ans = 0;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        fishList = new int[16][4]; // r, c, dir, num
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1; // 배열의 index로 접근하려고 1 빼기
                map[i][j] = num;
                fishList[i * 4 + j] = new int[]{i, j, dir, num};
            }
        }
        Arrays.sort(fishList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });
//        System.out.println(Arrays.deepToString(fishList));
        // 처음에 0,0을 먹고 시작
        shark = new int[4];
        shark[0] = 0;
        shark[1] = 0;
        int[] fish = fishList[map[0][0] - 1];
        shark[2] = fish[2];
        shark[3] = fish[3];
        removed[fish[3]] = true;
        map[0][0] = 0;

        dfs(0);
        System.out.println(ans);


    }

    static void dfs(int depth) {

        ans = Math.max(ans, shark[3]);

        // 물고기 원래 값 저장
        int[][] tmpFishList = new int[16][4];
        for (int i = 0; i < 16; i++)
            tmpFishList[i] = fishList[i].clone();
        // map 원래 값 저장
        int[][] tmpMap = new int[N][N];
        for (int i = 0; i < N; i++)
            tmpMap[i] = map[i].clone();


        // 물고기 이동
        for (int i = 0; i < 16; i++) {
            int[] fish = fishList[i];
            if (removed[fish[3]]) {
                continue;
            } // 제거된 물고기는 넘어가기
            int r = fish[0];
            int c = fish[1];
            int dir = fish[2];
            int num = fish[3];
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[(dir + d) % 8]; // 45도씩 회전
                int nc = c + dc[(dir + d) % 8];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (nr == shark[0] && nc == shark[1]) // 상어 위치랑 겹치면 다음 방향 탐색
                        continue;
                    // 아니라면 자리 바꾸기
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = num;
                        fish[0] = nr;
                        fish[1] = nc;
                        fish[2] = (dir + d) % 8;
                        map[r][c] = 0;
                    } else {
                        int[] change = fishList[map[nr][nc] - 1];

                        change[0] = r;
                        change[1] = c;
                        map[r][c] = change[3]; // 자리 이동
                        fish[0] = nr;
                        fish[1] = nc;
                        map[nr][nc] = num;
                        fish[2] = (dir + d) % 8; // 자리 이동, 방향 변경

                    }
                    break;
                }
            }
        }


        // 이동 이후 물고기 값 저장
        int[][] tmpFishList2 = new int[16][4];
        for (int i = 0; i < 16; i++)
            tmpFishList2[i] = fishList[i].clone();
        // 이동 이후 map 값 저장

        System.out.println("map");
        int[][] tmpMap2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            tmpMap2[i] = map[i].clone();
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("map");

        // 상어 원래 값 저장

        int nr = shark[0] + dr[shark[2]];
        int nc = shark[1] + dc[shark[2]];


        // 상어 이동 후 잡아먹기
        System.out.println("상어 이동");
        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            System.out.println(nr + " " + nc);
            // 해당 칸에 물고기가 없으면 nr, nc 검사
            if (map[nr][nc] == 0 || removed[map[nr][nc]]) {
                nr += dr[shark[2]];
                nr += dc[shark[2]];
                continue;
            }

            int[] eat = fishList[map[nr][nc] - 1];
            // 물고기가 있으면 잡아먹기

            // 현재 상어
            System.out.println("잡아먹기 전 shark");
            System.out.println(Arrays.toString(shark));

            int[] tmpShark = shark.clone();

            shark[0] = eat[0];
            shark[1] = eat[1];
            shark[2] = eat[2];
            shark[3] += eat[3];
            // 먹은 곳 0 으로 만들기
            map[eat[0]][eat[1]] = 0;

            removed[eat[3]] = true;


            dfs(depth + 1);

            shark= tmpShark.clone();
            // 원상 복구

            System.out.println("복구 후 shark");
            System.out.println(Arrays.toString(shark));

            for (int i = 0; i < N; i++)
                map[i] = tmpMap2[i].clone();
            for (int i = 0; i < 16; i++)
                fishList[i] = tmpFishList2[i].clone();
            removed[eat[3]] = false;

            nr += dr[shark[2]];
            nc += dc[shark[2]];

        }

//        // 원상 복구

//        for (int i = 0; i < N; i++)
//            map[i] = tmpMap[i].clone();
//        for (int i = 0; i < 16; i++)
//            fishList[i] = tmpFishList[i].clone();


    }

}
