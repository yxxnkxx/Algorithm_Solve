package SWEA.모의sw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_2383_점심식사 {

	static class Person {
		int e1; // s1까지의 거리
		int e2; // s2까지의 거리
		int r; // 좌표
		int c; // 좌표

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int N;
	static ArrayList<Person> list;
	static int[][] map;
	static int[] s1;
	static int[] s2;
	static boolean[] pick;
	static int[] time;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			list = new ArrayList<>();
			s1 = new int[3]; // {r, c, val}
			s2 = new int[3];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					int v = sc.nextInt();
					if (v == 1)
						list.add(new Person(i, j));
					else if (v != 0 && v != 1) {
						if (s1[2] == 0) {
							s1[0] = i;
							s1[1] = j;
							s1[2] = v;
						} else {
							s2[0] = i;
							s2[1] = j;
							s2[2] = v;
						}
					}
				}

			// 계단과의 거리 update
			for (int i = 0; i < list.size(); i++) {
				Person p = list.get(i);
				p.e1 = Math.abs(p.r - s1[0]) + Math.abs(p.c - s1[1]);
				p.e2 = Math.abs(p.r - s2[0]) + Math.abs(p.c - s2[1]);
			}

			/// 입력
			pick = new boolean[list.size()];
			time = new int[list.size()];
			pick(0);

			System.out.println("#" + t + " " + ans);

		}
	}

	static void pick(int depth) {
		// 최대 2^N의 경우의 수가 가능. 계단 1 또는 2 선택
		if (depth == list.size()) {
			find();
			return;
		}

		pick[depth] = false;
		pick(depth + 1);
		pick[depth] = true;
		pick(depth + 1);
	}

	static void find() {
		// pick이 true면 1, false면 2
		ArrayList<Person> pick1 = new ArrayList<>();
		ArrayList<Person> pick2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (pick[i])
				pick1.add(list.get(i));
			else
				pick2.add(list.get(i));
		}

		// 거리가 가까운 순으로 계단 방문
		pick1.sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.e1 - o2.e1;
			}
		});

		for (int i = 0; i < pick1.size(); i++) {
			if (i < 3) {
				time[i] = pick1.get(i).e1 + s1[2] + 1; // 거리 + 계단 내려가는 시간
			} else
				time[i] = Math.max(pick1.get(i).e1 + 1, time[i - 3]) + s1[2]; // 내가 거기까지 가는 거리, i-3번째가 완료하는 시간 중 큰 값
			// 계단은 도착 1분 후에 내려갈 수 있음

		}

		pick2.sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.e2 - o2.e2;
			}
		});
		int size1 = pick1.size();
		// 3개까지는 그냥 넣기
		for (int i = 0; i < pick2.size(); i++) {

			if (i < 3)
				time[i + size1] = pick2.get(i).e2 + s2[2] + 1; // 거리 + 계단 내려가는 시간
			else
				time[i + size1] = Math.max(pick2.get(i).e2 + 1, time[i + size1 - 3]) + s2[2];
		}

		Arrays.sort(time);
		ans = Math.min(ans, time[list.size() - 1]);

	}

}
