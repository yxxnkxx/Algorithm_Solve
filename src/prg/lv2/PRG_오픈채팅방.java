package prg.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PRG_오픈채팅방 {
	public static String[] solution(String[] record) {
		Map<String, String> names = new HashMap<>();
		List<String> tmp = new ArrayList<>();
		names.put("Enter", "님이 들어왔습니다.");
		names.put("Leave", "님이 나갔습니다.");
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String comm = st.nextToken();
			String id = st.nextToken();
			String nickname = "";
			switch (comm) {
			case "Enter":
				tmp.add(id + " Enter");
				nickname = st.nextToken();
				names.put(id, nickname);
				break;
			case "Leave":
				tmp.add(id + " Leave");
				break;
			case "Change":
				nickname = st.nextToken();
				names.put(id, nickname);
				break;
			}

		}

		String[] answer = new String[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			StringTokenizer st = new StringTokenizer(tmp.get(i));
			answer[i] = names.get(st.nextToken()) + names.get(st.nextToken());
		}

		return answer;

	}

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

}
