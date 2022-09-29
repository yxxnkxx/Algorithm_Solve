
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] p;
	static int[] route;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		p = new int[N + 1];
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				map[i][j] = sc.nextInt();
		route = new int[M];
		for (int i = 0; i < M; i++)
			route[i] = sc.nextInt();

		// make-set
		for (int i = 1; i <= N; i++)
			p[i] = i;

		// 연결되어 있으면 union 하기
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					int st = findSet(i);
					int ed = findSet(j);
					if (st != ed) { // 다른 set
						p[st] = ed; // union
					}
				}
			}

		// 여행 경로 union 찾기
		boolean check = true;
		for (int i = 1; i < M; i++) {
			int st = route[i - 1];
			int ed = route[i];
			if (findSet(st) != findSet(ed)) {
				check = false;
				break;
			}
		}
		if (check)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

}
