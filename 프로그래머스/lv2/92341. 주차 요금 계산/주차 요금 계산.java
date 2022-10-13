import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    public int[] solution(int[] fees, String[] records) {

		List<int[]> list = new ArrayList<>(); // 0:차번호, //1:시작시간
		Map<Integer, Integer> carTime = new HashMap<>();
		label: for (int i = 0; i < records.length; i++) {
			String[] input = records[i].split(" ");
			int hour = Integer.parseInt(input[0].substring(0, 2));
			int time = Integer.parseInt(input[0].substring(3, 5)) + hour * 60;
			int car = Integer.parseInt(input[1]);
			String comm = input[2];
			if (comm.equals("IN")) {
				list.add(new int[] { car, time });
			} else if (comm.equals("OUT")) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == car) {
						if (carTime.containsKey(car))
							carTime.put(car, carTime.get(car) + time - list.get(j)[1]);
						else
							carTime.put(car, time - list.get(j)[1]);
						list.remove(j);
						continue label;
					}
				}
			}
		}
		// 출차 안된 건 23:59
		int outTime = 23 * 60 + 59;
		for (int i = 0; i < list.size(); i++) {
			int car = list.get(i)[0];
			int time = list.get(i)[1];
			if (carTime.containsKey(car))
				carTime.put(car, carTime.get(car) + outTime - time);
			else
				carTime.put(car, outTime - time);
		}
		Integer[] carList = carTime.keySet().toArray(new Integer[0]);
		Arrays.sort(carList);
		int[] answer = new int[carTime.size()];
		// fees : 기본 시간, 기본 요금, 단위 시간, 단위 요금
		for (int i = 0; i < carList.length; i++) {
			int time = carTime.get(carList[i]);
			answer[i] = fees[1]; // 기본요금
			if (time > fees[0]) {
				time -= fees[0];
				answer[i] += (time / fees[2]) * fees[3];
				if (time % fees[2] != 0)
					answer[i] += fees[3];
			}
		}

		return answer;
    }
}