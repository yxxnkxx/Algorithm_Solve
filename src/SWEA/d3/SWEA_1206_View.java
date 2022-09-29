package SWEA.d3;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1206_View {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				arr.add(sc.nextInt());
			}
			int cnt = 0;
			int[] distance = new int[4];
			label: for (int i = 2; i < N - 2; i++) {

				int floor = arr.get(i);
				distance[0] = floor - arr.get(i - 2);
				distance[1] = floor - arr.get(i - 1);
				distance[2] = floor - arr.get(i + 1);
				distance[3] = floor - arr.get(i + 2);
				int minDis = 256;
				for (int d = 0; d < 4; d++) {
					if (distance[d] <= 0)
						continue label;
					if (distance[d] < minDis)
						minDis = distance[d];
				}
				if (minDis != 256)
					cnt += minDis;

			}
			System.out.println("#" + (t + 1) + " " + cnt);
		}
	}

}
