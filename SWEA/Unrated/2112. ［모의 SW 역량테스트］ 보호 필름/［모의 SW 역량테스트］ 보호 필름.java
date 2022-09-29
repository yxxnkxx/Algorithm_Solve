import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
    static int D, W, K;
    static int[][] arr;
    static int ans;
    static boolean[] check;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            ans = 0;
            D = sc.nextInt(); // row
            W = sc.nextInt(); // column
            K = sc.nextInt(); // 합격 기준
            arr = new int[D][W + 1];
            check = new boolean[W];
            for (int d = 0; d < D; d++) {
                arr[d][W] = -1;
                for (int w = 0; w < W; w++)
                    arr[d][w] = sc.nextInt();
            }
            // 입력
 
            bfs();
            System.out.println("#" + t + " " + (ans - 1));
        }
    }
 
    static void bfs() {
        Queue<int[][]> q = new LinkedList<>();
 
        q.add(arr);
        while (!q.isEmpty()) {
 
            int size = q.size();
            // q사이즈만큼 돌리기
            ans++;
            while (size-- > 0) {
                int[][] tmp = q.poll();
                if (test(tmp))
                    return;
                // 성능 검사를 통과하지 못한 곳 을 찾아서 하나씩 바꿔보기
                // 한 번 바꾼 줄은 더 이상 바꾸지 않게 해야됨
                for (int w = 0; w < W; w++)
                    if (check[w]) {
                        for (int d = 0; d < D; d++) {
                            int origin = tmp[d][w];
                            if (tmp[d][W] != origin) {
                                int[] copy = tmp[d].clone();
 
                                if (origin == 0)
                                    Arrays.fill(tmp[d], 1);
                                else
                                    Arrays.fill(tmp[d], 0);
                                int[][] newarr = new int[D][W];
                                for (int i = 0; i < D; i++)
                                    newarr[i] = tmp[i].clone();
                                q.add(newarr);
                                tmp[d] = copy.clone(); // 원상복구
                                tmp[d][W] = origin; // 방문 표시하기
                            }
                        }
                        break;
                    }
            }
 
        }
 
    }
 
    static boolean test(int[][] arr) {
        // 성능검사
 
        Arrays.fill(check, false);
 
        int cnt = 0;
        label: for (int w = 0; w < W; w++) {
            int tmp = 1;
            for (int d = 0; d < D - 1; d++) {
                if (arr[d][w] == arr[d + 1][w])
                    tmp++;
                else
                    tmp = 1;
                if (tmp == K) {
                    cnt++;
                    continue label;
                }
 
            }
            check[w] = true;
        }
        if (cnt == W)
            return true;
        return false;
 
    }
}