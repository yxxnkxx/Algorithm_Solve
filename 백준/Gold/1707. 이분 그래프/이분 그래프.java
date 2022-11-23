
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    static int V, E;
    static List<Integer>[] adjList;
    static int[] visited;
    static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            V = sc.nextInt();
            E = sc.nextInt();
            adjList = new ArrayList[V + 1];

            for (int i = 1; i <= V; i++)
                adjList[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                int st = sc.nextInt();
                int ed = sc.nextInt();
                adjList[st].add(ed);
                adjList[ed].add(st);
            }


            check = true;
            visited = new int[V + 1];
            Arrays.fill(visited, -1);
            for (int i = 1; i <= V; i++) {
                if (visited[i] == -1) {
                    visited[i] = 1;
                    dfs(i);
                    if (!check) break;
                }
            }
            if (check) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int i) {
        if (!check) return;
        for (int idx = 0; idx < adjList[i].size(); idx++) {
            int next = adjList[i].get(idx);

            // 자기 자신이랑 연결되어있으면 false
            if (next == i) {
                check = false;
                return;
            }
            if (visited[next] != -1 && visited[next] == visited[i]) {
                check = false;
                return;
            } else if (visited[next] == -1) { // 방문x
                visited[next] = (visited[i] + 1) % 2;
                dfs(next);
            }
        }
        
    }
}
