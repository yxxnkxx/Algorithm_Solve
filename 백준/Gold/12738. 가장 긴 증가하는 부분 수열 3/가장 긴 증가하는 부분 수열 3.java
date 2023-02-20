
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 추가하기
        list.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if (arr[i] > list.get(list.size() - 1))
                list.add(arr[i]);
            else {
                binarySearch(i, arr);
            }
        }
        System.out.println(list.size());

    }

    static void binarySearch(int i, int[] arr) {
        int start = 0;
        int end = list.size()-1;
        // 들어갈 위치 찾기
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[i] <= list.get(mid))
                end = mid;
            else {
                start = mid + 1;
            }
        }
        list.set(start, arr[i]);
    }
}
