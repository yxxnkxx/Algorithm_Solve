package Silver.s5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2628_종이자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int N = sc.nextInt();
		List<Integer> listX = new ArrayList<>();
		listX.add(0); // 처음 값
		List<Integer> listY = new ArrayList<>();
		listY.add(0);
		for (int i = 0; i < N; i++) {
			if (sc.nextInt() == 0)
				listY.add(sc.nextInt());
			else
				listX.add(sc.nextInt());
		}
		listX.add(x); // 마지막 값
		listY.add(y); // 마지막 값
		Collections.sort(listX);
		Collections.sort(listY);
		int maxX = 0;
		int maxY = 0;
		for (int i = 1; i < listX.size(); i++) {
			maxX = Math.max(maxX, listX.get(i) - listX.get(i - 1));
		}

		for (int i = 1; i < listY.size(); i++) {
			maxY = Math.max(maxY, listY.get(i) - listY.get(i - 1));

		}
		System.out.println(maxX * maxY);

	}

}
