package BOJ.Platinum.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11438_LCA2 {

    static int N, M;
    static List<Integer>[] adjList;
    static int[] rank;
    static int[][] parent;
    static StringBuilder sb = new StringBuilder();

    static int maxLevel;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();
        rank = new int[N + 1];


        int tmp = 100000;
        maxLevel = 1;
        while (tmp > 1) {
            tmp /= 2;
            maxLevel++;
        } // logN
        parent = new int[N + 1][maxLevel + 1];


        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        dfs(1, 0);
        findParent();


        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            LCA(br);
        }
        System.out.print(sb);
    }

    private static void findParent() {
        for (int i = 1; i <= maxLevel; i++)
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1]; // j의 2^j번째 조상 = j의 2^i-1번째 조상의 2^i-1번째 조상
            }
    }

    private static void LCA(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // A가 깊이가 더 깊은 애로 맞춰주기
        if (rank[start] < rank[end]) {
            int tmp = start;
            start = end;
            end = tmp;
        }

        // 두 노드의 깊이가 같아질 때까지 2^k번
        for (int i = maxLevel; i >= 0; i--) {
            if (Math.pow(2, i) <= rank[start] - rank[end])
                start = parent[start][i];
        }

        // 두 노드가 같아졌다면
        if (start == end) {
            sb.append(start).append("\n");
            return;
        }

        // 높이는 같지만, 부모가 같지 않을 경우 같은 부모를 찾아서 ㄱㄱ
        for (int i = maxLevel; i >= 0; i--) {
            if (parent[start][i] != parent[end][i]) { // 두 노드의 부모가 같은 노드의 직전까지 감
                start = parent[start][i];
                end = parent[end][i];
            }
        }


        sb.append(parent[start][0]).append("\n");
    }

    static void dfs(int curr, int p) {
        rank[curr] = rank[p] + 1;
        parent[curr][0] = p;

        for (int i = 0; i < adjList[curr].size(); i++) {
            int child = adjList[curr].get(i);
            if (rank[child] == 0 && child != p) {
                dfs(child, curr);
            }
        }
    }
}
