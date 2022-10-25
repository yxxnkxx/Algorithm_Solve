package BOJ.Gold.g2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_12015_LIS2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        list.add(sc.nextInt());
        for (int i = 1; i < N; i++) {
            int num = sc.nextInt();
            if (num > list.get(list.size() - 1)) {
                list.add(num);
                cnt++;
            } else {
                int idx = find(num, list);
                list.set(idx, num);
            }
        }
        System.out.println(cnt);

    }

    static int find(int num, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= num) {
                end = mid;
            } else
                start = mid + 1;
        }
        return end;
    }
}
