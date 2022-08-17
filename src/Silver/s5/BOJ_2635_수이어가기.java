package Silver.s5;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2635_수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = N / 2; i <= N; i++) { // 1 처리
			int tmp = 2;
			int first = N;
			int second = i;
			while (first - second >= 0) {
				tmp++;
				int next = first - second;
				first = second;
				second = next;
			}
			if (tmp > cnt) {
				cnt = tmp;
				list.clear();
				list.add(second);
				list.addFirst(first);
				while (tmp > 2) {
					int prev = first + second;
					second = first;
					first = prev;
					list.addFirst(first);
					tmp--;
				}

			}
		}
		System.out.println(cnt);
		for (Integer num : list) {
			System.out.print(num + " ");
		}

	}

}
