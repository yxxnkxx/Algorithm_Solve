package Silver.s4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(), c = sc.nextInt();
		int t = sc.nextInt();
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		for (int tc = 0; tc < t; tc++) {
			int d = sc.nextInt();
			int l = sc.nextInt();
			if (d == 0 && l <= c) {
				arr1.add(l);
			} else if (d == 1 && l <= r) {
				arr2.add(l);
			}
		}
		if (arr1.size() == 0) {
			arr1.add(c);
		}
		if (arr2.size() == 0) {
			arr2.add(r);
		}
		Collections.sort(arr1);
		Collections.sort(arr2);
		arr1.add(c - arr1.get(arr1.size() - 1));
		arr2.add(r - arr2.get(arr2.size() - 1));
		for (int i = 1; i < arr1.size() - 1; i++) {
			arr1.set(i, arr1.get(i) - arr1.get(i - 1));
		}
		for (int i = 1; i < arr2.size() - 1; i++) {
			arr2.set(i, arr2.get(i) - arr2.get(i - 1));
		}
		int tmp = 0, max = 0;
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				tmp = arr1.get(i) * arr2.get(j);
				if (max < tmp) {
					max = tmp;
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
}