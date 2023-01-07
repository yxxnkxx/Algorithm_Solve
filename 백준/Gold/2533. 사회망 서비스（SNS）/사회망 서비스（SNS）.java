import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) {
        // 자기 자신이 1일 때와 0일 때를 구분 -> 0이라면 인접 노드는 무조건 1, 1이라면 인접 노드의 값 중 최소값
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        for (int i = 0; i < N-1; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            adjList[st].add(ed);
            adjList[ed].add(st);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int i) {
        visited[i] = true;
        dp[i][0] = 0;
        dp[i][1] = 1;
        visited[i] = true;

        // 0일 때는 인접한 노드가 1일 때의 값을 모두 더하기
        for (Integer num : adjList[i]) {
            if (!visited[num]) {
                dfs(num);
                dp[i][0] += dp[num][1];
                dp[i][1] += Math.min(dp[num][1], dp[num][0]);
            }
        }
    }
}