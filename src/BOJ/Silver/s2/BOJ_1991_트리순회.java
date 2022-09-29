package BOJ.Silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] tree = new String[26][3]; // data left right
		tree[0][0] = "A";

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			int pIdx = p.charAt(0) - 'A';

			// 각 알파벳의 index는 A가 0, B가 1 ...
			if (!left.equals(".")) {
				tree[left.charAt(0) - 'A'][0] = left;
				tree[pIdx][1] = left;
			}
			if (!right.equals(".")) {
				tree[right.charAt(0) - 'A'][0] = right;
				tree[pIdx][2] = right;
			}
		} // tree 입력

		preOrder(tree, 0);
		sb.append("\n");
		inOrder(tree, 0);
		sb.append("\n");
		postOrder(tree, 0);
		System.out.println(sb.toString());
	}

	static StringBuilder sb = new StringBuilder();

	static void preOrder(String[][] tree, int i) {
		if (tree[i][0] != null) {
			sb.append(tree[i][0]);
			if (tree[i][1] != null)
				preOrder(tree, tree[i][1].charAt(0) - 'A');
			if (tree[i][2] != null)
				preOrder(tree, tree[i][2].charAt(0) - 'A');
		}
	}

	static void inOrder(String[][] tree, int i) {
		if (tree[i][0] != null) {
			if (tree[i][1] != null)
				inOrder(tree, tree[i][1].charAt(0) - 'A');
			sb.append(tree[i][0]);
			if (tree[i][2] != null)
				inOrder(tree, tree[i][2].charAt(0) - 'A');
		}
	}

	static void postOrder(String[][] tree, int i) {
		if (tree[i][0] != null) {
			if (tree[i][1] != null)
				postOrder(tree, tree[i][1].charAt(0) - 'A');
			if (tree[i][2] != null)
				postOrder(tree, tree[i][2].charAt(0) - 'A');
			sb.append(tree[i][0]);
		}
	}

}
