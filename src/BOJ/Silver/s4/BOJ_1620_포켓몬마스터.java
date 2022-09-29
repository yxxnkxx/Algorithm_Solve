package BOJ.Silver.s4;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1620_포켓몬마스터 {
	final static String PATTERN = "^[0-9]*$";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String name = sc.next();
			map1.put(name, i);
			map2.put(i, name);
		}

		for (int i = 0; i < M; i++) {
			String input = sc.next();
			if (input.matches(PATTERN))
				System.out.println(map2.get(Integer.parseInt(input)));

			else
				System.out.println(map1.get(input));
		}
	}

}
