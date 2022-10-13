    class Solution {
        public String solution(String new_id) {

		// 대문자를 소문자로
		// 알파벳 소문자 숫자 빼기 밑줄 마침표를 제외한 모든 문자 제거
		String answer = "";
		int change = 'A' - 'a';
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);

			if (c >= 'A' && c <= 'Z')
				c = (char) (c - change);
			if (c >= 'a' && c <= 'z')
				answer += c;
			else if (c >= '0' && c <= '9')
				answer += c;
			else if (c == '-' || c == '_' || c == '.')
				answer += c;

		}

		// 마침표가 2번 이상 연속되면 하나의 마침표로 치환
		answer = answer.replaceAll("\\.+", ".");

		// 앞뒤 .을 없애기
		if (answer.charAt(0) == '.')
			answer = answer.substring(1);
		if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
			answer = answer.substring(0, answer.length() - 1);
		// 빈문자열 a대입
		if (answer.length() == 0)
			answer = "a";

		// 6단계
		if (answer.length() > 15) {
			answer = answer.substring(0, 15);
			if (answer.charAt(answer.length() - 1) == '.')
				answer = answer.substring(0, answer.length() - 1);
		}

		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		while (answer.length() <= 2)
			answer += answer.charAt(answer.length() - 1);
		return answer;
        }
    }