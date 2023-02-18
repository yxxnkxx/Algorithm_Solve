import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Edge implements Comparable<Edge> {
        int st;
        int ed;
        int dist;

        public Edge(int st, int ed, int dist) {
            this.st = st;
            this.ed = ed;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    static int N, M; // 집(노드) 길(간선)
    static List<Edge>[] adjList;
    static int total;
    static boolean[] visited;

    public static void main(String[] args) {
        // 최소신장트리 -> 전체 합에서 최소신장트리의 거리만큼 빼기
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            M = sc.nextInt();
            N = sc.nextInt();
            if (N == 0 && M == 0) break;
            adjList = new List[M];
            visited = new boolean[M];
            total = 0;
            for (int i = 0; i < M; i++)
                adjList[i] = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int st = sc.nextInt();
                int ed = sc.nextInt();
                int dist = sc.nextInt();
                total += dist; // 전체 비용
                adjList[st].add(new Edge(st, ed, dist));
                adjList[ed].add(new Edge(ed, st, dist)); // 양방향
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            visited[0] = true;
            pq.addAll(adjList[0]);
            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                if (visited[e.ed]) continue;
                visited[e.ed] = true;
                total-=e.dist;
                for (int i=0; i<adjList[e.ed].size(); i++) {
                    Edge tmp = adjList[e.ed].get(i);
                    if (!visited[tmp.ed]) pq.add(tmp);
                }
            }
            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }
}