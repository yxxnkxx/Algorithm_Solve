package BOJ.Silver.s4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 듣
		int M = sc.nextInt(); // 보

		HashSet<String> notHear = new HashSet<>();
		HashSet<String> notSee = new HashSet<>();

		for (int i = 0; i < N; i++)
			notHear.add(sc.next());
		for (int i = 0; i < M; i++)
			notSee.add(sc.next());

		ArrayList<String> result = new ArrayList<>();
		for (String name : notHear) {
			if (notSee.contains(name))
				result.add(name);
		}
		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for (String name : result)
			sb.append(name).append("\n");
		System.out.print(sb.toString());
	}

}
