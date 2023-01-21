package BOJ.Silver.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13335_트럭 {
    static class Node {

        int weight;
        int duration;

        public Node(int weight, int duration) {
            this.weight = weight;
            this.duration = duration;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int w = sc.nextInt(); // 다리 길이
        int L = sc.nextInt(); // 다리 최대 하중
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[][] times = new int[N][2];

        int time = 1;
        int currWeight = 0;
        int idx = 0;
        Queue<Node> q = new LinkedList();
        for (idx = 0; idx < N; idx++) {
            if (currWeight + arr[idx] <= L) {
                times[idx][0] = time++;
                times[idx][1] = times[idx][0] + w;
                currWeight += arr[idx];
            } else {
                break;
            }
        }

        int startIdx = 0;


        while (idx < N) {

            // startIdx 하나 빼기
            currWeight -= arr[startIdx];
            int startTime = times[startIdx][1]; // startIdx가 나온 시간
            startIdx++;

            while (idx < N && currWeight + arr[idx] <= L) {
                times[idx][0] = Math.max(times[idx - 1][0] + 1, startTime); // 더 큰 시간으로 들어감
                times[idx][1] = times[idx][0] + w;
                currWeight += arr[idx];
                idx++;
            }


        }

        System.out.println(times[N - 1][1]);


    }
}
