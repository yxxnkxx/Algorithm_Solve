package prg.lv1;

import java.util.*;

public class PRG_신고결과받기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{
                        "muzi", "frodo", "apeach", "neo"
                }, new String[]{
                        "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"
                }
                , 2)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>(); // key: 신고한 유저, value: 그 유저가 신고한 유저(신고당한 유저)
        Map<String, Integer> reportCnt = new HashMap<>(); // key: 유저 이름, value: 신고받은 횟수
        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            reportCnt.put(id_list[i], 0);
        }

        for (int i = 0; i < report.length; i++) {
            String[] names = report[i].split(" ");
            String doReport = names[0];
            String getReport = names[1];
            Set<String> reportSet = reportMap.get(doReport);
            if (reportSet.contains(getReport)) continue; // 같은 사람을 여러 번 신고했는지 체크
            reportSet.add(getReport);
            reportMap.put(doReport, reportSet);
            /// 신고한 유저

            reportCnt.put(getReport, reportCnt.get(getReport) + 1);
            // 신고받은 횟수


        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            Set<String> reportSet = reportMap.get(id_list[i]);
            for (String str : reportSet) {
                int cnt = reportCnt.get(str);
                if (cnt >= k) answer[i]++;
            }
        }

        return answer;
    }
}
