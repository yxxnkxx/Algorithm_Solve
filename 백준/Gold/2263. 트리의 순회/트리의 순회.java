import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] in;
	static int[] post;
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		in = new int[N + 1];
		post = new int[N];
		visited = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			in[Integer.parseInt(st.nextToken())] = i;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			post[i] = Integer.parseInt(st.nextToken());
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
			mid = in[root];
			visited[root] = true;
			sb.append(root + " ");
			preOrder(left, mid - 1 - cnt, cnt);
			preOrder(mid - cnt, right - 1, cnt + 1);
		}
	}
}