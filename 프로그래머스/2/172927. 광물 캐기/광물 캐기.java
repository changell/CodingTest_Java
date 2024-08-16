import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalPick = Arrays.stream(picks).sum();
        int[][] group = new int[totalPick][3];
        int dia = 0, iron = 0, stone = 0;
        int idx = 0;
        
        for(int i = 0; i< minerals.length; i+=5){
            if(i/5==totalPick) break;
            
            for(int j = i; j<i+5; j++){
                switch (minerals[j]) {
                    case "diamond":
                        dia += 1;
                        iron += 5;
                        stone += 25;
                        
                        break;
                    case "iron":
                        dia += 1;
                        iron += 1;
                        stone += 5;
                        
                        break;
                    case "stone":
                        dia += 1;
                        iron += 1;
                        stone += 1;
                        
                        break;
                }
                
                if(minerals.length -1 == j) break;
            }
            group[i/5][0] = dia;
            group[i/5][1] = iron;
            group[i/5][2] = stone;
            
            dia = iron = stone = 0;
        }
        
        //피로도 높은순 기준 내림차순 정렬
        Arrays.sort(group, (a1, a2) -> (a2[2]-a1[2]));

        for (int i = 0; i < totalPick; i++) {
            String pick = picks[0] > 0 ? "diamond" : picks[1] > 0 ?
                "iron" : "stone";

            switch (pick) {
                case "diamond":
                    answer += group[i][0];
                    picks[0]--;
                    break;
                case "iron":
                    answer += group[i][1];
                    picks[1]--;
                    break;
                case "stone":
                    answer += group[i][2];
                    picks[2]--;
                    break;
            }
        }
        
        return answer;
    }
}