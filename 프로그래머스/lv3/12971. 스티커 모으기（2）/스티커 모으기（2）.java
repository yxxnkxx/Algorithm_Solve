class Solution {
    
    static int N;
    static int ans;
        public static int solution(int[] stickers) {

        N = stickers.length;
        if (N==1) {
            return stickers[0]; // 길이가 1일 때
        }

        int[][] dp = new int[N][2]; // 0은 포함o, 1은 포함x
        dp[0][0] = stickers[0];

        dp[1][0] = stickers[1];
        dp[1][1] = dp[0][0];
        // 1~n-1까지하고 마지막은 따로
        for (int i = 2; i < N - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][0]) + stickers[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        ans = Math.max(dp[N - 2][0], dp[N - 2][1]); // 마지막은 포함x
        // 1에서 시작해서 N-2까지
        dp[1][1] = 0; // 첫 번째 포함x
        dp[0][0] = 0;
        for (int i = 2; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][0]) + stickers[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        ans = Math.max(ans, dp[N - 1][0]);
        ans = Math.max(ans, dp[N - 1][1]);


        return ans;
    }

   }