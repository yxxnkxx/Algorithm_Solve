package Silver.s4;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1269_대칭차집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		HashSet<Integer> setA = new HashSet<>();

		int cnt = 0; // 공통 개수 찾기
		for (int i = 0; i < A; i++)
			setA.add(sc.nextInt());
		for (int i = 0; i < B; i++)
			if (setA.contains(sc.nextInt()))
				cnt++;
		System.out.println(A + B - 2 * cnt);
	}

}
