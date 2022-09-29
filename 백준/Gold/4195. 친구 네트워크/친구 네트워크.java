import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> p;
	static ArrayList<Integer> rank;
	static Map<String, Integer> names;
	static ArrayList<Integer> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int F = sc.nextInt();
			p = new ArrayList<>(); // 부모를 담을 곳..
			rank = new ArrayList<>();
			names = new HashMap<>();
			ans = new ArrayList<>();
			for (int i = 0; i < F; i++) {
				String f1 = sc.next();
				String f2 = sc.next();

				// 이름 찾기
				if (!names.containsKey(f1)) {
					int id = p.size();
					p.add(id);
					rank.add(0);
					ans.add(1);
					names.put(f1, id);
				}
				if (!names.containsKey(f2)) {
					int id = p.size();
					p.add(id);
					rank.add(0);
					ans.add(1);
					names.put(f2, id);
				}
				//////////////// 연결하기
				union(names.get(f1), names.get(f2));
				int cnt = ans.get(findSet(names.get(f1)));
				sb.append(cnt).append("\n");
			}
		}
		System.out.print(sb);
	}

	static int findSet(int i) {
		if (p.get(i) != i)
			p.set(i, findSet(p.get(i)));
		return p.get(i);

	}

	static void union(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);

		if (pi != pj) { // cycle 방지
			if (rank.get(pi) > rank.get(pj)) {
				p.set(pj, pi);
				ans.set(pi, ans.get(pi) + ans.get(pj));
			} else {
				p.set(pi, pj);
				ans.set(pj, ans.get(pj) + ans.get(pi));
			}
			if (rank.get(pi) == rank.get(pj))
				rank.set(pj, pj + 1);
		}
	}

}