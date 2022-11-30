
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer>[] adjList;
    static int[] rank;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();
        rank = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        dfs(1, 0);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i<M; i++) {
            LCA(br);
        }
        System.out.print(sb);
    }

    private static void LCA(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int rankA = rank[start];
        int rankB = rank[end];
        if (rankA != rankB) {
            while (rankA > rankB) {
                rankA--;
                start = parent[start];
            }
            while (rankB > rankA) {
                rankB--;
                end = parent[end];
            }
        }
        while (start!=end) {
            start=parent[start];
            end=parent[end];
        }
        sb.append(start).append("\n");
    }

    static void dfs(int curr, int p) {
        rank[curr] = rank[p] + 1;
        parent[curr] = p;

        for (int i = 0; i < adjList[curr].size(); i++) {
            int child = adjList[curr].get(i);
            if (rank[child] == 0 && child != p) {
                dfs(child, curr);
            }
        }
    }
}
