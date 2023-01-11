
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", value=" + value +
                    '}';
        }
    }


    static int N, Q;
    static List<Edge>[] adjList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        adjList = new List[N + 1];


      
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            adjList[start].add(new Edge(start, end, value));
            adjList[end].add(new Edge(end, start, value));
        }


        StringBuilder sb = new StringBuilder();
        // 질문에 답하기
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int cnt = 0;
            // 최소 신장 트리
            boolean[] visit = new boolean[N + 1];
            visit[V] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(V);
            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int j = 0; j < adjList[curr].size(); j++) {
                    Edge e = adjList[curr].get(j);
                    if (!visit[e.end] && e.value >= K) {
                        // K보다 큰 값을 찾는 것이니까, value가 K보다 작다면 해당 edge에 연결된 노드들은 무조건 K보다 작음, 더 볼 필요가 없다
                        q.add(e.end);
                        visit[e.end] = true;
                        cnt++;
                    }
                }
            }


            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

    }
}
