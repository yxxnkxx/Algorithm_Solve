import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[] arr;

    static int[] visited;
    static int[] order;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new int[N + 1];
            arr = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            order = new int[N+1];
            for (int i = 1; i <= N; i++) {
                if (visited[i]==0) {
                    dfs(i, i, 1);
                }
            }
            sb.append(N-cnt).append("\n");


        }
        System.out.print(sb);
    }

    static void dfs(int start, int i, int o) {

        order[i] = o;
        int next = arr[i];
        visited[i] = start;
        if (visited[next]==start&& order[next] != 0) { // 이번 사이클에서 방문
            cnt += (o - order[next] + 1);
            return;

        }
        if (visited[next]!=0) return;

        dfs(start, next, o + 1);


    }


}