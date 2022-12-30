import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] adjList;
    static int[] indegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        indegree = new int[N + 1];
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            int start = sc.nextInt();
            while (num-- > 1) {
                int end = sc.nextInt();
                adjList[start].add(end);
                indegree[end]++;
                start = end;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0) q.add(i);
        int count = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append("\n");
            count++;
            for (int i = 0; i < adjList[num].size(); i++) {
                int tmp = adjList[num].get(i);
                indegree[tmp]--;
                if (indegree[tmp] == 0)
                    q.add(tmp);
            }
        }
        if (count < N)
            System.out.println(0);
        else System.out.println(sb);

    }
}