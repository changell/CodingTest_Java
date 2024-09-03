class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLeng = t.length();
        int pLeng = p.length();

        // p의 길이와 동일한 길이의 부분 문자열을 만들어야 하므로 right를 pLeng-1로 설정
        for (int i = 0; i <= tLeng - pLeng; i++) {
            String result = t.substring(i, i + pLeng); // p의 길이만큼 부분 문자열 생성
            
            long tNum = Long.parseLong(result); // 길이가 클 수 있으니 long으로 변환
            long pNum = Long.parseLong(p);
            
            if (tNum <= pNum) {
                answer++;
            }
        }
        
        return answer;
    }
}