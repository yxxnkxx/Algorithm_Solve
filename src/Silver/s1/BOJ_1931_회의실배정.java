package Silver.s1;

import java.util.Arrays;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return start + " " + end;
	}

	@Override
	public int compareTo(Meeting o) {

		return this.start - o.start;
	}

}

public class BOJ_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] arr = new Meeting[N];
		for (int i = 0; i < N; i++)
			arr[i] = new Meeting(sc.nextInt(), sc.nextInt());

		Arrays.sort(arr);

		int ans = 0;

	}

}
