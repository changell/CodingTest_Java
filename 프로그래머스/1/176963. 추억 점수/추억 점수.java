import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int idx = 0;
        
        Map<String, Integer> map = new LinkedHashMap<>();
        
        
        for(int i = 0; i< name.length; i++){
            map.put(name[i],yearning[i]);
        }
        
        for(String[] characters : photo){
            int charactersIdx = 0;
            
            for(String person : characters){
                Set<String> keys = map.keySet();

                for (String key : keys) {
                    if(person.equals(key)){
                        charactersIdx += map.get(key);
                    }
                }
                
            }
            answer[idx] = charactersIdx;
            idx++;
        }
        	
        return answer;
    }
}