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
	public int compareTo(Meeting o) {
		if (this.end == o.end)
			return this.start - o.start;
		return this.end - o.end;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start + " " + end;
	}

}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] arr = new Meeting[N];
		for (int i = 0; i < N; i++)
			arr[i] = new Meeting(sc.nextInt(), sc.nextInt());

		Arrays.sort(arr);
		int end = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i].start >= end) {
				cnt++;
				end = arr[i].end;
			}
		}
		System.out.println(cnt);

	}

}