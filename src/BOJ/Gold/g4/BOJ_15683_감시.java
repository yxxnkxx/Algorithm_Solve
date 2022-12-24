package BOJ.Gold.g4;

import java.util.*;

public class BOJ_15683_감시 {
    static Map<Integer, int[][]> rMap;
    static Map<Integer, int[][]> cMap;
    static int N, M;

    static List<int[]> cctv;
    static int ans;

    public static void main(String[] args) {

        rMap = new HashMap<>();
        cMap = new HashMap<>();
        cctv = new ArrayList<>();
        rMap.put(1, new int[][]{{1}, {-1}, {0}, {0}});
        cMap.put(1, new int[][]{{0}, {0}, {1}, {-1}});
        rMap.put(2, new int[][]{{1, -1}, {0, 0}});
        cMap.put(2, new int[][]{{0, 0}, {1, -1}});
        rMap.put(3, new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}});
        cMap.put(3, new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}});
        rMap.put(4, new int[][]{{1, 0, -1}, {0, -1, 0}, {-1, 0, 1}, {0, 1, 0}});
        cMap.put(4, new int[][]{{0, -1, 0}, {-1, 0, 1}, {0, 1, 0}, {1, 0, -1}});
        rMap.put(5, new int[][]{{1, -1, 0, 0}});
        cMap.put(5, new int[][]{{0, 0, 1, -1}});

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ans = N * M;
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] >= 1 && arr[i][j] <= 5) cctv.add(new int[]{i, j});
            }

        dfs(0, arr);
        System.out.println(ans);


    }

    static void dfs(int idx, int[][] map) {

        if (idx == cctv.size()) {
            int cnt = 0;
            for (int n = 0; n < N; n++)
                for (int m = 0; m < M; m++)
                    if (map[n][m] == 0) cnt++;
            ans = Math.min(cnt, ans);
            return;
        }
        int i = cctv.get(idx)[0];
        int j = cctv.get(idx)[1];

        int[][] tmp = new int[N][M]; // 원래 map 저장
        for (int n = 0; n < N; n++)
            tmp[n] = map[n].clone();


        int[][] rArr = rMap.get(map[i][j]);
        int[][] cArr = cMap.get(map[i][j]);
        for (int k = 0; k < rArr.length; k++) {
            int[] dr = rArr[k];
            int[] dc = cArr[k];
            // map 초기화
            for (int n = 0; n < N; n++)
                map[n] = tmp[n].clone();
            for (int d = 0; d < dr.length; d++) {
                int nr = i + dr[d];
                int nc = j + dc[d];
                while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 6) {
                    if (map[nr][nc] == 0) map[nr][nc] = -1;
                    nr += dr[d];
                    nc += dc[d];
                }
            }

            dfs(idx + 1, map);
        }


    }
}
