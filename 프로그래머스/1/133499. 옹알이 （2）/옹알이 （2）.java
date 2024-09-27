class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] validWords = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            // 체크 변수
            String previous = "";

            // 가능한 발음으로 단어 대체
            boolean canPronounce = true;
            while (!word.isEmpty()) {
                boolean found = false;
                
                for (String valid : validWords) {
                    if (word.startsWith(valid) && !valid.equals(previous)) {
                        word = word.substring(valid.length()); // 발음 제거
                        previous = valid; // 이전 발음 저장
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    canPronounce = false;
                    break;
                }
            }
            
            if (canPronounce) {
                answer++;
            }
        }
        
        return answer;
    }
}