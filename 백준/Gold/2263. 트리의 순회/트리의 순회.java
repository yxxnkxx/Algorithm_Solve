import java.util.Scanner;

public class Main {
	static int[] in;
	static int[] post;
	static int N;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		in = new int[N];
		post = new int[N];
		visited = new boolean[N + 1];
		for (int i = 0; i < N; i++)
			in[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			post[i] = sc.nextInt();
		preOrder(0, N - 1, 0);
		System.out.println(sb.toString());
	}

	static StringBuilder sb = new StringBuilder();

	static void preOrder(int left, int right, int cnt) {
		if (left <= right) {
			int root = post[right];
			if (visited[root])
				return;

			int mid = 0; // in에서 root의 index
			for (int i = 0; i < N; i++)
				if (in[i] == root) {
					mid = i;
					break;
				}
			visited[root] = true;
			sb.append(root + " ");
			preOrder(left, mid - 1 - cnt, cnt);
			preOrder(mid - cnt, right - 1, cnt + 1);
		}
	}
}