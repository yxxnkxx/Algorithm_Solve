package BOJ0725;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1316_그룹단어체커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int n = 0; n < N; n++) {
			boolean checkPrev = false;
			boolean isGroup = true;
			ArrayList<Character> check = new ArrayList<>();
			String input = sc.next();
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
//				if (!check.contains(c) &&) {
//					
//				}
			}
		}
	}

//	check prev false -> 더 이상 안 나오면 그룹 단어 O
//	check prev true->continue 

}
