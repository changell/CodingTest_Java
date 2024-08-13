import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new LinkedHashMap<>();
        
        for(int i = 0; i < players.length; i++)
            map.put(players[i], i);
        
        for(int j =0; j < callings.length; j++ ){
            String callPlayer = callings[j];        //불린 선수
            int idx = map.get(callPlayer);          //순위 체크
            String changePlayer = players[idx-1];   //앞선 선수
            
            players[idx-1] = callPlayer;    //불린 선수 +1
            players[idx] = changePlayer;    //앞선 선수 -1
            
            //순위 값 할당
            map.put(callPlayer, idx-1);
            map.put(changePlayer, idx);
        }

        String[] array = new String[map.size()];
        
        Set<String> keys = map.keySet();
        
        //순위 대로 1차원 배열 할당
        for(String key : keys){
            int idx = map.get(key);
            array[idx] = key;
        }
        
        return array;
    }
}