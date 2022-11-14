package BOJ.Gold.g5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11000_강의실배정 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        pq.add(arr[0][1]); // 첫번째의 끝나는 시간을 추가
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][0]) {
                // i번째 시작 시간이 pq의 끝나는 시간보다 크다면, 강의실 추가 x
                pq.poll();
                pq.add(arr[i][1]); // 끝나는 시간을 추가
            } else {
                pq.add(arr[i][1]);
            }
        }
        System.out.println(pq.size());


    }


}
