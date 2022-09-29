package SWEA.d3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1213_String {
	static int[] skip = new int[11];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int T = sc.nextInt();

			// pattern의 길이 n-1-charAt(i) : skip할 크기
			String pattern = sc.next();
			String find = sc.next();
			Arrays.fill(skip, 0);
			for (int i = 0; i < pattern.length(); i++) {
				skip[i] = pattern.length() - 1 - i;
			}

			int cnt = 0;
			int patternIdx = pattern.length() - 1;
			int findIdx = 0;
			label: while (findIdx < find.length()) {
				while (find.charAt(findIdx) == pattern.charAt(patternIdx)) {

//					System.out.println(find.charAt(findIdx) + " " + findIdx);
					if (patternIdx == 0) {
						cnt++;
						patternIdx = pattern.length() - 1;
						findIdx += pattern.length();
						continue label;
					}
					patternIdx--;
					findIdx--;

				}
				if (findIdx + 1 < find.length() && find.charAt(findIdx) != find.charAt(findIdx + 1)
						&& pattern.contains(String.valueOf(find.charAt(findIdx)))) {
					findIdx += skip[pattern.indexOf(find.charAt(findIdx))];
				} else {
					findIdx += pattern.length();

				}
				patternIdx = pattern.length() - 1;

			}

			System.out.println("#" + T + " " + cnt);
		}
	}

}
