package prg.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PRG_개인정보수집유효기간 {

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    static public int[] solution(String today, String[] terms, String[] privacies) {
        // privacies의 만료기간 구하기
        Map<String, Integer> map = new HashMap<>(); // terms
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            String type = st.nextToken();
            int month = Integer.parseInt(st.nextToken());
            map.put(type, month);
        }

        String[] curr = today.split("\\.");
        int currDate = Integer.parseInt(curr[2]); // 일
        currDate += Integer.parseInt(curr[1]) * 28; // 월
        currDate += (Integer.parseInt(curr[0]) - 2000) * 28 * 12; // 년
        int[] answer = new int[privacies.length];
        int[] result = new int[privacies.length];
        int idx = 0;
        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            String[] date = tmp[0].split("\\.");
            int add = map.get(tmp[1]) * 28; // 몇달을 더할 것인지
            result[i] += add-1;
            result[i] += Integer.parseInt(date[2]); // 일
            result[i] += Integer.parseInt(date[1]) * 28; // 월
            result[i] += (Integer.parseInt(date[0]) - 2000) * 28 * 12; // 년
            if (result[i] < currDate) {
                answer[idx++] = i + 1;
            }
        }


        return Arrays.copyOfRange(answer, 0, idx);
    }
}
