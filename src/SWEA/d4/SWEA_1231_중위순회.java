package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1231_중위순회 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] tree = new String[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				String alphabet = st.nextToken();
				tree[index] = alphabet;
			}
			sb.append("#" + t + " ");
			inOrder(tree, 1);
			System.out.println(sb.toString());
			sb.setLength(0);
		}

	}// main

	static void inOrder(String[] tree, int i) {
		if (i < tree.length) {
			inOrder(tree, 2 * i);
			sb.append(tree[i]);
			inOrder(tree, 2 * i + 1);
		}
	}
}
