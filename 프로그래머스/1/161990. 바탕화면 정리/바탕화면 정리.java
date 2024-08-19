import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        List<Integer> wList = new ArrayList<>();
        List<Integer> lList = new ArrayList<>();
        
        for(int i = 0; i< wallpaper.length; i++){
            for(int j =0 ; j < wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                //if  파일 존재 여부 
                if(c == '#'){
                    wList.add(j);   //가로 리스트에 좌표 값 add
                    lList.add(i);   //세로 리스트에 좌표 값 add
                }
            }
        }
        
        answer[0] = Collections.min(lList);     //작은 세로 값
        answer[1] = Collections.min(wList);     //작은 가로 값
        answer[2] = Collections.max(lList) + 1; //큰 세로 값 +1
        answer[3] = Collections.max(wList) + 1; //큰 가로 값 +1
            
        return answer;
    }
}