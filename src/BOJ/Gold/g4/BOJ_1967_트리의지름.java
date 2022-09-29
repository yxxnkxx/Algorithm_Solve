package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
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
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes[parent].childs.add(nodes[child]);
			nodes[parent].weights.add(weight); // 같은 index는 child와 거기의 거리를 의미함
			nodes[child].childs.add(nodes[parent]);
			nodes[child].weights.add(weight); // 부모 노드도 똑같이 추가해줌 나중에 리프 노드부터 올라와야 하니까
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

		for (int i = 0; i < node.childs.size(); i++) {
			TreeNode child = node.childs.get(i);
			if (!visited[child.data]) {
				visited[child.data] = true;
				if (sum + node.weights.get(i) > ans) {
					ans = sum + node.weights.get(i); // 길이 update
					other = child.data; // other node update
				}
				dfs(child.data, sum + node.weights.get(i));
				visited[child.data] = false;
			}
		}
	}
}

class TreeNode {
	int data;
	List<TreeNode> childs;
	List<Integer> weights;

	public TreeNode(int data) {
		this.data = data;
		childs = new ArrayList<>();
		weights = new ArrayList<>();
	}

}