package Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4256_트리_2 {
	static int idx;
	static int[] preOrder;
	static int[] inOrder;// value, index
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			preOrder = new int[N];
			idx = 0;
			StringTokenizer pre = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				preOrder[i] = Integer.parseInt(pre.nextToken());
			StringTokenizer in = new StringTokenizer(br.readLine());
			inOrder = new int[N];
			for (int i = 0; i < N; i++)
				inOrder[i] = Integer.parseInt(in.nextToken()); // value와 index

			postOrder(0, N - 1);
			sb.append("\n");
		}
		System.out.print(sb.toString());

	}

	static void postOrder(int start, int end) {
		if (start > end)
			return;
		int data = preOrder[idx++]; // 검색할 root
		int rootIdx = -1;
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == data) {
				rootIdx = i;
				break;
			}
		}

		postOrder(start, rootIdx - 1);
		postOrder(rootIdx + 1, end);
		sb.append(data).append(" ");

	}
}
