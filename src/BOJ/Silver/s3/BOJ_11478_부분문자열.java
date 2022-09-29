package BOJ.Silver.s3;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_11478_부분문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		HashSet<String> set = new HashSet<>();
		// 길이가 1부터 input.length() 까지의 부분수열이 존재함
		int length = input.length();

		for (int start = 0; start < length; start++) {
			for (int end = start + 1; end <= length; end++) {
				set.add(input.substring(start, end));
			}
		}
		System.out.println(set.size());
	}

}
