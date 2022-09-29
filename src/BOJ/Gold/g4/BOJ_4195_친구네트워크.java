package BOJ.Gold.g4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_4195_친구네트워크 {

	static int[] p;
	static int[] rank;
	static Map<String, Integer> names;
	static int[] ans;
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int F = sc.nextInt();
			size = 0;
			p = new int[200000]; // 부모를 담을 곳..
			rank = new int[200000];
			names = new HashMap<>();
			ans = new int[200000];
			for (int i = 0; i < F; i++) {
				String f1 = sc.next();
				String f2 = sc.next();
				// 이름 찾기
				if (!names.containsKey(f1)) {
					int id = size++;
					ans[id] = 1;
					p[id] = id;
					names.put(f1, id);
				}
				if (!names.containsKey(f2)) {
					int id = size++;
					ans[id] = 1;
					p[id] = id;
					names.put(f2, id);
				}
				//////////////// 연결하기
				union(names.get(f1), names.get(f2));
				int cnt = ans[findSet(names.get(f1))];
				sb.append(cnt).append("\n");
			}
		}
		System.out.print(sb);
	}

	static int findSet(int i) {
		if (p[i] != i)
			p[i] = findSet(p[i]);
		return p[i];

	}

	static void union(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);

		if (pi != pj) { // cycle 방지
			if (rank[pi] > rank[pj]) {
				p[pj] = pi;
				ans[pi] += ans[pj];
			} else {
				p[pi] = pj;
				ans[pj] += ans[pi];
			}
			if (rank[pi] == rank[pj])
				rank[pj] += 1;
		}
	}

}
