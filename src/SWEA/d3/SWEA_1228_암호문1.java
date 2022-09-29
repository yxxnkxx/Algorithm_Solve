package SWEA.d3;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1228_암호문1 {
	static Scanner sc = new Scanner(System.in);
	static LinkedList<String> origin = new LinkedList<>();

	public static void main(String[] args) {
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			for (int i = 0; i < N; i++)
				origin.offer(sc.next()); // 원본 암호문
			int C = sc.nextInt(); // 명령 개수
			for (int i = 0; i < C; i++) {
				command(sc.next());
			}
			sb.append("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(origin.get(i) + " ");
			}
			sb.append("\n");
			origin.clear();
		}
		System.out.println(sb.toString());
	}

	static void command(String input) {
		switch (input) {
		case "I":
			int idx = sc.nextInt();
			int N = sc.nextInt();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				origin.add(idx + cnt, sc.next()); // idx에 추가 -> 그 다음 idx에 추가
				cnt++;
			}
			break;
		}
	}

}
