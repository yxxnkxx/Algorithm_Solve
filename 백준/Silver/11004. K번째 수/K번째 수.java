import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		for (int i = 0; i < N; i++)
//			pq.offer(sc.nextInt());
//		for (int i = 0; i < K - 1; i++) {
//			pq.poll();
//		}
//		System.out.println(pq.poll());
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		Collections.sort(list);
		System.out.println(list.get(K - 1));
	}
}