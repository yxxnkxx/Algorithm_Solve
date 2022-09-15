package Silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11725_TreeParent {
	static LinkedList<Integer>[] arr;
	static int N;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new LinkedList[N + 1];
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new LinkedList<Integer>(); // i의 자식노드만 남기기
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			arr[v1].add(v2);
			arr[v2].add(v1);

		}

		dfs(1);

		for (int i = 2; i <= N; i++)
			sb.append(parents[i]).append("\n");
		System.out.print(sb.toString());

	}

	static void dfs(int parent) {

		for (int i = 0; i < arr[parent].size(); i++) {
			int child = arr[parent].get(i);
			if (parents[child] == 0) {
				parents[child] = parent; // 자식 노드 추가
				dfs(child);

			}

		}

	}

}
