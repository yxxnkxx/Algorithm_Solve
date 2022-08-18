package Silver.s2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2304_창고다각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer[]> arr = new ArrayList<>();

		int maxY = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (y > maxY) {
				maxY = y;
			}
			arr.add(new Integer[] { x, y });
		}
		Collections.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		int sum = 0;
		int x1 = arr.get(0)[0];
		int y1 = arr.get(0)[1];
		int i;
		for (i = 0; i < arr.size(); i++) {
			int y2 = arr.get(i)[1];
			int x2 = arr.get(i)[0];

			if (y1 < y2) { // 뒤 값이 더 크면 앞까지 넓이 업데이트
				sum += (x2 - x1) * y1;
				y1 = y2;
				x1 = x2;
			}

			if (y2 == maxY) {
				x1 = x2;
				y1 = y2;
				break;
			}
		} // 오름차순

		// 가장 높은 값만큼 면적 업데이트
		sum += y1; // y1=maxY
		int x2 = 0;
		int y2 = 0;
		int x3 = arr.get(arr.size() - 1)[0]; // 마지막값
		int y3 = arr.get(arr.size() - 1)[1];

		// 내림차순 -> 뒤에서부터 검사
		for (int j = arr.size() - 2; j > i; j--) {
			y2 = arr.get(j)[1];
			x2 = arr.get(j)[0];

			if (y2 > y3) { // 가장 마지막 높이보다 크면 업데이트
				sum += y3 * (x3 - x2);
				x3 = x2;
				y3 = y2;
			}
		}

		sum += y3 * (x3 - x1); // 마지막 값 업데이트
		System.out.println(sum);

	}

}
