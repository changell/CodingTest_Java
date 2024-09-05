class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0, diff = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(answer == 0 ? 0 : i - same - diff)) {
                same++;
            } else {
                diff++;
            }

            // if 동일한 개수의 문자와 다른 문자가 같아지면 카운트 증가
            if (same == diff) {
                answer++;
                same = diff = 0;  // 카운터 초기화
            }
        }

        // 마지막 남은 부분이 있다면 추가 카운트
        if (same != 0 || diff != 0) {
            answer++;
        }

        return answer;
    }
}