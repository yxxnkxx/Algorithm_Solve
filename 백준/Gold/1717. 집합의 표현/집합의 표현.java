
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		p = new int[N + 1];
		// make-set
		for (int i = 0; i <= N; i++)
			p[i] = i;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int comm = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			switch (comm) {
			case 0:
				// union
				p[findSet(b)] = p[findSet(a)];
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
