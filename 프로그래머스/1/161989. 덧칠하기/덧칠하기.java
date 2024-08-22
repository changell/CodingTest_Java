class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int currentEnd = section[0] + m;    //처음 페인트칠 했을때 길이 값 체크
        
        for(int i = 0; i< section.length; i++){
            int currentSection = section[i];
            //if 페인트 칠 길이 > section 순회 값 비교
            if(currentEnd > currentSection) continue;
            
            currentEnd = currentSection + m;   //페인트 칠 길이 값 최신화
            answer ++;        //페인트 칠한 수 + 1
            
        }
        
        return answer;
    }
}