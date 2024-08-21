import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        //keymap문자열 리스트에 추가
        List<String> list = new LinkedList<>();
        for(int i = 0; i<keymap.length; i++){
            list.add(keymap[i]);
        }
        
        for(int i = 0; i < targets.length; i++){
            List<Integer> findIdx = new ArrayList<>();
            int saveIdx = 0;    //문자열에서 문자 위치의 idx값의 합을 저장
            
            for(int j = 0; j < targets[i].length(); j++){
                char c = targets[i].charAt(j);
                findIdx.clear();
                
                for (int z = 0; z < list.size(); z++) {
                    String str = list.get(z);
                    int index = str.indexOf(c); //문자열에서 문자 인덱스 찾기
                    
                    //if 문자 인덱스 존재 시 리스트에 add
                    if(index != -1) findIdx.add(index + 1);
                    
                }
                
                //if 리스트가 비었는지 여부
                if (!findIdx.isEmpty()) {
                    saveIdx += Collections.min(findIdx);    //리스트에 존재하는 낮은값 += 처리
                } else {
                    saveIdx = -1;                           //비었으면 -1 처리
                    break; 
                }
                
            }
            
            answer[i] = saveIdx;    //인덱스 저장
            
        }
        
        return answer;
    }
}