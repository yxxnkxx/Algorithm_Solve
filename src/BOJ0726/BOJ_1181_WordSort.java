package BOJ0726;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1181_WordSort {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(sc.next());
		}
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				} else {
					return o1.compareTo(o2);
				}

			}
		});

		for (int i = 0; i < arr.size(); i++) {
			if (i == 0 || !arr.get(i - 1).equals(arr.get(i))) {
				System.out.println(arr.get(i));
			}
		}

	}

}
