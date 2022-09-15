package Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1167_트리지름 {
	static int V;
	static int ans;
	static int[] nodes;
	HashMap<Integer, LinkedList<Integer>> tree; //

	// 처음에는 서로의 관계만 저장해서, visited를 통해 순회하려고 했음
	// 그런데 1부터 시작하면 1이 루트노드인 경우에 길이를 제대로 계산x
	// 모든 노드 또는 리프 노드부터 dfs를 각각 수행하면 시간 초과
	// 결국 트리를 구현해서 전위순회를 해야함!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		nodes = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			nodes[i] = i; // 1부터 V까지를 번호로 하는 정점 생성
		}
		Tree tree = new Tree();
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int child = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());

			while (true) {
				if (parent == -1)
					break;
				int distance = Integer.parseInt(st.nextToken());
				nodes[child].parent = nodes[parent];
				nodes[child].map.put(nodes[parent], distance);
				nodes[parent].childs.add(nodes[child]);
				nodes[parent].map.put(nodes[child], distance);
				if (tree.root == null || tree.root == nodes[child]) {
					tree.root = nodes[parent];
				}
				parent = Integer.parseInt(st.nextToken());
			}
		}

	}

}

class Tree {
	TreeNode root;

	public Tree() {
		root = null;
	}

}

class TreeNode {
	int data;
	boolean visited;
	TreeNode parent;
	List<TreeNode> childs;
	HashMap<TreeNode, Integer> map;

	public TreeNode(int data) {
		this.data = data;
		this.visited = false;
		childs = new ArrayList<>();
		map = new HashMap<>();
	}

}
