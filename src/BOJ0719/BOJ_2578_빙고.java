package BOJ0719;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2578_빙고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 5;

		ArrayList<Integer>[] bingo = new ArrayList[5];
		ArrayList<Integer>[] check = new ArrayList[5];
		for (int i = 0; i < N; i++) {
			bingo[i] = new ArrayList<Integer>();
			check[i] = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				bingo[i].add(sc.nextInt());
				check[i].add(0);
			}
		}

		int bingoCnt = 0;
		int cnt = 0;

		while (true) {
			int call = sc.nextInt();
			cnt++;
			for (int i = 0; i < N; i++) {
				if (bingo[i].contains(call)) {
					int idx = bingo[i].indexOf(call);
					check[i].set(idx, 1);
				}
			}

			int diagCheckLeft = 0;
			int diagCheckRight = 0;
			bingoCnt = 0;
			for (int i = 0; i < N; i++) {
				int colCheck = 0;
				if (!check[i].contains(0)) {
					bingoCnt++;
				}
				for (int j = 0; j < N; j++) {
					if (check[j].get(i) == 1) {
						colCheck++;
					} else {
						colCheck = 0;
					}

				}
				if (colCheck == 5) {
					bingoCnt++;
				}

				if (check[i].get(i) == 1) {
					diagCheckLeft++;
				}
				if (check[i].get(4 - i) == 1) {
					diagCheckRight++;
				}

			}
			if (diagCheckLeft == 5) {
				bingoCnt++;
			}
			if (diagCheckRight == 5) {
				bingoCnt++;
			}

			if (bingoCnt >= 3) {
				System.out.println(cnt);
				break;
			}

		}

	}

}
