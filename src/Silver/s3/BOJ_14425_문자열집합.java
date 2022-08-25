package Silver.s3;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_14425_문자열집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(sc.next());
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String input = sc.next();
			if (set.contains(input))
				cnt++;
		}
		System.out.println(cnt);
	}

}
