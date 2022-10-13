import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] house;
	static int dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i = 0; i < N; i++)
			house[i] = Integer.parseInt(br.readLine());
		Arrays.sort(house);
		int ans = 0;
		int d = 0;
		int left = 1; // 거리가 1일 때가 최소
		int right = house[N - 1] - house[0]; // 두 공유기 사이의 거리의 최대값
		while (left <= right) {
			int mid = (left + right) / 2;
			int start = house[0];
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				d = house[i] - start;
				if (d >= mid) {
					// mid를 최소 거리로 할 때 가능한 공유기의 개수를 세는 것
					start = house[i];
					cnt++;
				}
			}
			if (cnt >= C) {
				ans = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}
		System.out.println(ans);

	}

}