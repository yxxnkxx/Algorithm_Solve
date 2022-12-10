import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int st;
        int ed;
        int d;

        public Edge(int st, int ed, int d) {
            this.st = st;
            this.ed = ed;
            this.d = d;
        }


        @Override
        public int compareTo(Edge o) {
            return this.d - o.d;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "st=" + st +
                    ", ed=" + ed +
                    ", d=" + d +
                    '}';
        }
    }

    static int N; // 도시 개수
    static int M; // 버스 개수 (간선)
    static List<Edge>[] adjList; // 인접 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            adjList[start].add(new Edge(start, end, dis));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(start, end));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dis = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dis, 100001 * N);
        dis[start] = 0;
        pq.add(new Edge(start, start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.ed]) continue;
            visited[e.ed] = true;

            for (int i = 0; i < adjList[e.ed].size(); i++) {
                Edge tmp = adjList[e.ed].get(i);

                if (!visited[tmp.ed] && dis[tmp.ed] > dis[tmp.st] + tmp.d) {
                    dis[tmp.ed] = dis[tmp.st] + tmp.d;
                    pq.add(new Edge(tmp.st, tmp.ed, dis[tmp.ed]));
                }
            }


        }

        return dis[end];
    }

}