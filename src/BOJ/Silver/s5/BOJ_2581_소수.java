package BOJ.Silver.s5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2581_소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int M = sc.nextInt();
		int N = sc.nextInt();

		label: for (int i = M; i <= N; i++) {
			if (i == 1)
				continue;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					continue label;
				}
			}
			list.add(i);
		}

		if (list.size() == 0) {
			System.out.println(-1);
			return;
		}

		int sum = 0;
		int min = 100001;
		for (Integer num : list) {
			sum += num;
			if (num < min)
				min = num;
		}
		System.out.println(sum);
		System.out.println(min);
	}

}
