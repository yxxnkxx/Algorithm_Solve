package BOJ.Gold.g3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1520_내리막길 {

    static int M, N; // M=r, N=c
    static int[][] map;
    static int[][] dp;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1; // 초기화
            }
        dp[0][0] = 1; //처음 시작

        find(M - 1, N - 1);
        System.out.println(dp[M-1][N-1]);
    }

    static int find(int r, int c) {
        if (dp[r][c]!=-1) return dp[r][c];

        int ans =0;
        for (int d=0; d<4; d++) {
            int nr= r+dr[d];
            int nc=c+dc[d];
            if (nr>=0 && nr<M && nc>=0 && nc<N && map[nr][nc]>map[r][c]) {
                ans += find(nr, nc);
            }
        }
        return dp[r][c]=ans;


    }

}
