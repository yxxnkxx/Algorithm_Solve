package BOJ0719;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			arrayList.add(i - 1 - num, i);

		}

		for (int number : arrayList) {
			System.out.print(number + " ");
		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (int number : arrayList) {
//			sb.append(number);
//			sb.append(" ");
//		}
//		System.out.println(sb.toString().trim());
	}

}
