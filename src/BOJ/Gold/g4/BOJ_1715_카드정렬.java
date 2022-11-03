package BOJ.Gold.g4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715_카드정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++)
            pq.add(sc.nextInt());
        int sum = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum += (num1 + num2);
            pq.add(num1 + num2);
        }
        System.out.println(sum);
    }
}
