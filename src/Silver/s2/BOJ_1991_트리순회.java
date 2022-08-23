package Silver.s2;

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
			int pIdx = 0;
			for (int j = 0; j < 26; j++) {

			}

			if (tree[j] != null && tree[j].equals(p)) {
				pIdx = j;
				break;
			} // 부모 인덱스 찾기
			if (!left.equals("."))
				tree[pIdx * 2] = left;
			if (!right.equals("."))
				tree[pIdx * 2 + 1] = right;
		} // tree 입력
		preOrder(tree, 1);
		sb.append("\n");
		inOrder(tree, 1);
		sb.append("\n");
		postOrder(tree, 1);
		System.out.println(sb.toString());
	}

	static StringBuilder sb = new StringBuilder();

	static void preOrder(String[] tree, int i) {
		if (i <= tree.length && tree[i] != null) {
			sb.append(tree[i]);
			preOrder(tree, i * 2);
			preOrder(tree, i * 2 + 1);
		}
	}

	static void inOrder(String[] tree, int i) {
		if (i <= tree.length && tree[i] != null) {
			inOrder(tree, i * 2);
			sb.append(tree[i]);
			inOrder(tree, i * 2 + 1);
		}
	}

	static void postOrder(String[] tree, int i) {
		if (i <= tree.length && tree[i] != null) {
			postOrder(tree, i * 2);
			postOrder(tree, i * 2 + 1);
			sb.append(tree[i]);
		}
	}

}
