import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
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
        map[0][0] = -1;

        dfs(map, shark.clone(), fishList, removed);
        System.out.println(ans);


    }

    static void dfs(int[][] map, int[] shark, int[][] fishList, boolean[] removed) {

        ans = Math.max(ans, shark[3]);

        // 처음 맵 상태
        int[][] initMap = new int[4][4];
        for (int i=0; i<4; i++)
            initMap[i]=map[i].clone();
        int[][] initFish = new int[16][4];
        for (int i=0; i<16; i++)
            initFish[i] = fishList[i].clone();

        map[shark[0]][shark[1]]=-1;
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
                    if (map[nr][nc]==-1) // 상어 위치랑 겹치면 다음 방향 탐색
                        continue;
                    // 아니라면 자리 바꾸기
                    if (map[nr][nc] == 0) {
                        fish[0] = nr;
                        fish[1] = nc;
                        map[r][c] = 0;
                    } else {
                        int[] change = fishList[map[nr][nc] - 1];

                        change[0] = r;
                        change[1] = c;
                        map[r][c] = change[3]; // 자리 이동
                        fish[0] = nr;
                        fish[1] = nc;

                        // 자리 이동, 방향 변경

                    }
                    fish[2] = (dir + d) % 8; // 방향 변경
                    map[nr][nc] = num;
                    break;
                }
            }
        }


        // 상어 이동 후 잡아먹기
        for (int d = 1; d < 4; d++) {
            int nr = shark[0] + dr[shark[2]] * d;
            int nc = shark[1] + dc[shark[2]] * d;
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc]!=0) {

                // 배열 복사가 헷갈릴 때는 원상복구하지 말고 이동할 때 새로운 배열 생성하기~
                int[][] tmpFishList = new int[16][4];
                for (int i = 0; i < 16; i++)
                    tmpFishList[i] = fishList[i].clone();
                // 이동 이후 map 값 저장
                int[][] tmpMap = new int[N][N];
                for (int i = 0; i < N; i++) {
                    tmpMap[i] = map[i].clone();
                }
                tmpMap[shark[0]][shark[1]] = 0;
                int[] eat = tmpFishList[map[nr][nc] - 1];
                int eatNum = eat[3];
                boolean[] tmpRemove = removed.clone();
                tmpRemove[eatNum] = true;
                tmpMap[eat[0]][eat[1]] = -1;

                dfs(tmpMap, new int[]{eat[0], eat[1], eat[2], shark[3] + eat[3]}, tmpFishList, tmpRemove);


            }
        }

        for (int i=0; i<4; i++)
            map[i]=initMap[i].clone();
        for (int i=0; i<16; i++)
            fishList[i] = initFish[i].clone();


    }

}