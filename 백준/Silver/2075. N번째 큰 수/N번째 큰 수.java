import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
//		int[][] arr = new int[N][N];
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < N; j++)
//				arr[i][j] = Integer.parseInt(st.nextToken());
//
//		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				pq.offer(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < N - 1; i++)
			pq.poll();
		System.out.println(pq.poll());
		// 가장 큰 값을 찾고 row-1로 이동

	}

}