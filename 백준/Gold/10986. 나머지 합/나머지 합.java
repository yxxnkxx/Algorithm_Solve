
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] cnt = new long[M];
		cnt[0] = 1;
		st = new StringTokenizer(br.readLine());
		long curr = 0;
		for (int i = 0; i < N; i++) {
			curr = (curr + Long.parseLong(st.nextToken())) % M;
			cnt[(int) curr]++;
		}

		long ans = 0;
		for (int i = 0; i < M; i++)
			ans += cnt[i] * (cnt[i] - 1) / 2;
		System.out.println(ans);

	}
}
