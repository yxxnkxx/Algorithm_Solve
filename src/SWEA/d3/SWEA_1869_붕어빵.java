package SWEA.d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_1869_붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {

			int N = sc.nextInt(); // 예약 손님
			int M = sc.nextInt(); // 소요 시간
			int K = sc.nextInt(); // M초에 만들 수 있는 붕어빵의 수
			ArrayList<Integer> arr = new ArrayList<>();
			boolean isPossible = true;
			for (int n = 0; n < N; n++) {
				arr.add(sc.nextInt());
			}
			Collections.sort(arr);
			int visit = 0;
			for (int n = 0; n < N; n++) {
				int time = arr.get(n);
				int count = (time / M) * K - visit;
				visit++;
				if (count <= 0) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				System.out.println("#" + (t + 1) + " Possible");
			} else {
				System.out.println("#" + (t + 1) + " Impossible");
			}

		}

	}

}
