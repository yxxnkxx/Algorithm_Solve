import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static List<Integer> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] indegree = new int[N + 1];
		adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			adjList[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		ans = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			adjList[st].add(ed);
			indegree[ed]++;
		}

		// 방식1 큐
		// indegree가 0인 애들을 큐에 추가
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			if (indegree[i] == 0)
				q.add(i);
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp + " ");
			for (int j = 0; j < adjList[tmp].size(); j++) {
				int next = adjList[tmp].get(j);
				indegree[next]--;
				if (indegree[next] == 0)
					q.add(next);
			}

		}
		System.out.println(sb);

	}

//		// 방식2 dfs 활용
//		for (int i = 1; i <= N; i++)
//			if (!visited[i])
//				dfs(i);
//		for (int i = ans.size() - 1; i >= 0; i--)
//			System.out.print(ans.get(i) + " ");
//		System.out.println();

//	}

	static void dfs(int i) {
		visited[i] = true;
		for (int j = 0; j < adjList[i].size(); j++)
			if (!visited[adjList[i].get(j)])
				dfs(adjList[i].get(j));
		ans.add(i);
	}

}