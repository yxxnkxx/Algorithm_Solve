package Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4256_트리 {
	static int[] preOrder;
	static HashMap<Integer, Integer> inOrder;// value, index
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			preOrder = new int[N];
			StringTokenizer pre = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				preOrder[i] = Integer.parseInt(pre.nextToken());
			StringTokenizer in = new StringTokenizer(br.readLine());
			inOrder = new HashMap<>();
			for (int i = 0; i < N; i++)
				inOrder.put(Integer.parseInt(in.nextToken()), i); // value와 index

			// 입력

			MyNode root = new MyNode(preOrder[0]); // 전위순회 0번은 항상 root
			for (int i = 1; i < N; i++) {
				MyNode newNode = new MyNode(preOrder[i]);
				makeTree(inOrder.get(root.data), inOrder.get(preOrder[i]), root, newNode);

			}
			postOrder(root);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	static void makeTree(int rootIdx, int dataIdx, MyNode root, MyNode data) {
		// rootIdx와 자기 자신의 idx는 중위 순회 기준
		// 중위 순회에서 x의 index < rootIdx : 왼쪽, 아니면 오른쪽

		if (dataIdx < rootIdx) {
			// 왼쪽
			if (root.left == null)
				root.left = data; // 왼쪽 자식이 없으면 추가
			else
				makeTree(inOrder.get(root.left.data), dataIdx, root.left, data); // 있으면 다시 조사

		} else {
			// 오른쪽
			if (root.right == null)
				root.right = data; // 오른쪽 자식이 없으면 추가
			else
				makeTree(inOrder.get(root.right.data), dataIdx, root.right, data); // 있으면 다시 조사
		}

	}

	static void postOrder(MyNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			sb.append(root.data + " ");
		}

	}

}

class MyNode {
	int data;
	MyNode left;
	MyNode right;

	public MyNode(int data) {

		this.data = data;
		this.left = null;
		this.right = null;
	}

}