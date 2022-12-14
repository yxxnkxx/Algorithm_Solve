import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        int ans = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            int val = arr[i];
            visited[val] = true;
            if (map.containsKey(val - 1)) {
                map.put(val, map.get(val - 1) + 1);
                ans = Math.max(map.get(val - 1) + 1, ans);
                map.remove(val - 1);
            } else {
                if (val == N || visited[val + 1]) {
                    continue;
                }
                map.put(val, 1);
            }

        }
        System.out.println(N - ans);


    }

}