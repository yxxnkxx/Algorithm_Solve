package SWEA.d3;

import java.util.Scanner;

public class SWEA_4789_성공적인공연기획 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			char[] people = sc.next().toCharArray();
			int[] count = new int[people.length];
			for (int i = 0; i < count.length; i++) {
				if (i == 0)
					count[i] = people[i] - '0';
				else {
					count[i] = count[i - 1] + people[i] - '0'; // count는 누적 합
				}
			}
			// count의 index는 i명 이상이 박수칠 때 자신도 박수를 치는 사람들
			// 누적합인 각 index의 값이 i+1 이상일 때 모든 사람이 박수칠 수 있음
			int need = 0;
			for (int i = 0; i < count.length; i++) {
				if (count[i] + need < i + 1) {
					need += (i + 1 - count[i] - need); //
				}
			}
			System.out.println("#" + (t + 1) + " " + need);

		}

	}

}
