package BOJ.Gold.g3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11066_파일합치기 {
    static int[] arr;
    static int[][] dp;
    static int ans;
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            K = sc.nextInt();
            arr = new int[K];
            dp = new int[K][K];
            ans=0;
            for (int i=0; i<K; i++)
                arr[i]=sc.nextInt();
            for (int i=0; i<K; i++)
                Arrays.fill(dp[i], -1);
            dp[0][K-1] = Integer.MAX_VALUE;
            for (int i=0; i<K-1; i++) {
                dp[0][K-1] = Math.min(dp[0][K-1],find(0, i)+find(i+1,K-1));
            }
            System.out.println(Arrays.deepToString(dp));
            System.out.println(dp[0][K-1]);
            System.out.println(ans);

        }
    }

    static int find(int st, int ed) {

        if (st==ed) return dp[st][ed]=arr[st];

        if (dp[st][ed]!=-1) return dp[st][ed];
        int res = Integer.MAX_VALUE;
        for (int i=st; i<ed; i++) {
            res = Math.min(res, find(st, i)+find(i+1,ed));
        }
        ans+=res;
        dp[st][ed]=res;
        System.out.println(st+" "+ed+" "+res);
        return res;
    }
}
