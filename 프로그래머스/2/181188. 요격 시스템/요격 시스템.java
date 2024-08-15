import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        //끝점을 기준으로 오름차수 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int last = targets[0][1];   //첫번째 끝점 초기화 
        answer++;   //요격 발사
        
        for(int[] target : targets){
            // if 요격 발사된 시점보다 오른쪽에 있는지 여부 확인
            if(last <= target[0]){  
                last = target[1]; //끝점 변경
                answer ++; // 추가 요격 발사
            }
        }
        
        return answer;
    }
}