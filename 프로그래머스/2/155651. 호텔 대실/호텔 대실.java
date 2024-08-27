import java.util.*;
import java.time.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Integer> endTimes = new ArrayList<>();
        int[][] intTime = new int[book_time.length][2];
        
        //문자열 형식의 시간을 정수형으로 변환 후 intTime배열에 저장
        for(int i = 0; i < book_time.length; i++){
            int start_time = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end_time = Integer.parseInt(book_time[i][1].replace(":", "")) + 10;
            
            //분이 60 이상일 경우 시간 조정
            if (end_time % 100 >= 60) {
                end_time += 40;
            }
            
            intTime[i][0] = start_time;
            intTime[i][1] = end_time;
            
        }
        
        //오름차순 정렬
        Arrays.sort(intTime, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int i = 0; i < intTime.length; i++){
            boolean assigned = false;
            
            for(int j =0; j < endTimes.size(); j++){
                
                //if 대실 시작시간이 종료시간보다 같거나 이후 여부 ++
                if(intTime[i][0] >= endTimes.get(j)){
                    endTimes.set(j, intTime[i][1]);
                    assigned = true;
                    break;
                }
            }
            
            if(!assigned){
                endTimes.add(intTime[i][1]);
            }
            
        }
        
        return endTimes.size();
    }
    
}