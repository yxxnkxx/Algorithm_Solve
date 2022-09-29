
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N + 1];
		rank = new int[N + 1]; // 초기값은 0, union하면 증가
		// make-set
		for (int i = 0; i <= N; i++)
			p[i] = i;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			switch (comm) {
			case 0:
				// union
				// rank 활용
				int setA = findSet(a);
				int setB = findSet(b);
				if (rank[setA] > rank[setB])
					p[setB] = setA;
				else {
					p[setA] = setB;
					if (rank[setA] == rank[setB])
						rank[setB]++;
				}
				break;
			case 1:
				// find
				if (findSet(a) == findSet(b))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
				break;
			}

		}
		System.out.print(sb);
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

}
