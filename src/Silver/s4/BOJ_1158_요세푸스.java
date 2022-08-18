package Silver.s4;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158_요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 0;
		while (list.size() > 0) {
			cnt = (cnt + K - 1) % list.size();
			if (list.size() == 1) {
				sb.append(list.remove(cnt) + ">");
			} else
				sb.append(list.remove(cnt) + ", ");
		}

//		while (list.size() > 0) {
//			if (cnt != K) {
//				list.add(list.remove(0));
//				cnt++;
//			} else {
//				if (list.size() == 1) {
//					sb.append(list.remove(0) + ">");
//				} else {
//					sb.append(list.remove(0) + ", ");
//					cnt = 1;
//
//				}
//			}
//
//		}

		System.out.println(sb.toString());

	}

}
