package SWEA.d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_1208_Flattern {

	public static void main(String[] args) {
		int T = 10;
		int size = 100;

		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt(); // 덤프 횟수

			ArrayList<Integer> box = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				box.add(sc.nextInt());
			}

			Collections.sort(box);
			int dis = box.get(size - 1) - box.get(0);
			while (N > 0 && dis > 1) {
				box.set(0, box.get(0) + 1);
				box.set(size - 1, box.get(size - 1) - 1);
				Collections.sort(box);
				dis = box.get(size - 1) - box.get(0);
				N--;

			}
			System.out.println("#" + (t + 1) + " " + dis);
		}
	}

}
