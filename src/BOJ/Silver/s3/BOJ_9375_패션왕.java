package BOJ.Silver.s3;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_9375_패션왕 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			HashMap<String, Integer> map = new HashMap<>();
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				String name = sc.next();
				String type = sc.next();
				if (map.containsKey(type))
					map.put(type, map.get(type) + 1);
				else
					map.put(type, 1);
			}
			if (map.size() == 0)
				System.out.println(0);
			else {
				int result = 1;
				for (String key : map.keySet()) {
					result *= map.get(key) + 1; // 해당 종류를 선택하지 않는 경우의 수를 하나 추가함
				}
				System.out.println(result - 1); // 공집합 빼기
			}

		}
	}

}
