package Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1167_트리지름 {
	static int N;
	static TreeNode[] nodes;
	static boolean[] visited;

	static int ans;
	static int other = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new TreeNode[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new TreeNode(i);
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = (st.countTokens() - 1) / 2;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes[start].childs = new TreeNode[count];
			nodes[start].weights = new int[count];
			int idx = 0;
			while (true) {
				if (end == -1)
					break;
				int weight = Integer.parseInt(st.nextToken());
				nodes[start].childs[idx] = nodes[end];
				nodes[start].weights[idx++] = weight;
				end = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 0);
		Arrays.fill(visited, false);
		dfs(other, 0); // 루트노드에서 가장 먼 노드부터 다시 dfs 시행
		System.out.println(ans);
	}

	public static void dfs(int idx, int sum) {
		TreeNode node = nodes[idx];
		visited[idx] = true;

		if (idx == 0)
			return; // N이 1일 때 처리

		for (int i = 0; i < node.childs.length; i++) {
			TreeNode child = node.childs[i];
			if (!visited[child.data]) {
				visited[child.data] = true;
				if (sum + node.weights[i] > ans) {
					ans = sum + node.weights[i]; // 길이 update
					other = child.data; // other node update
				}
				dfs(child.data, sum + node.weights[i]);
				visited[child.data] = false;
			}
		}
	}
}

class TreeNode {
	int data;
	TreeNode[] childs;
	int[] weights;

	public TreeNode(int data) {
		this.data = data;
	}

}