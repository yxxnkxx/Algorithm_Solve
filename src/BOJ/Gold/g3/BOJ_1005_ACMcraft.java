package BOJ.Gold.g3;

import java.util.*;

public class BOJ_1005_ACMcraft {


    static int N, K, W; // 건물 개수, 간선
    static int[] times;
    static int[] visited;
    static List<Integer>[] adjList;
    static int ans;
    static int[] indegree;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = sc.nextInt();
            K = sc.nextInt();
            indegree = new int[N + 1];
            times = new int[N + 1];
            dp = new int[N + 1];
            for (int i = 1; i <= N; i++)
                times[i] = sc.nextInt();
            adjList = new List[N + 1];
            for (int i = 1; i <= N; i++)
                adjList[i] = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                int st = sc.nextInt();
                int ed = sc.nextInt();
                adjList[st].add(ed);
                indegree[ed]++;
            }
            W = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++)
                if (indegree[i] == 0)
                    q.add(i);
            while (!q.isEmpty()) {
                int tmp = q.poll();
                for (int j = 0; j < adjList[tmp].size(); j++) {
                    int next = adjList[tmp].get(j);
                    indegree[next]--;
                    dp[next] = Math.max(dp[next], dp[tmp] + times[tmp]);
                    if (indegree[next] == 0)
                        q.add(next);
                }
            }
            sb.append(dp[W]+times[W]).append("\n");
        }
        System.out.print(sb);

    }



}
