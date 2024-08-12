import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int sort_num;
        
        //ext 조건에 따른 값 추출
        for(int i = 0; i < data.length; i++){
            int value = 0;
            switch(ext){
                case "code" :
                    value = data[i][0];
                    break;
                case "date" :
                    value = data[i][1];
                    break;
                    
                case "maximum" :
                    value = data[i][2];
                    break;
                    
                default : 
                    value = data[i][3];
                    break;
                    
            }
            
            // list에 val_ext 조건에 맞는 값 add
            if(value < val_ext)
                list.add(data[i]);
            
        }
        
        //int[][] 2차원 배열 변환
        int[][] answer = list.toArray(new int[list.size()][]);
        
        switch(sort_by){
            case "code" :
                sort_num = 0;
                break;
            case "date" :
                sort_num = 1;
                break;

            case "maximum" :
                sort_num = 2;
                break;

            default : 
                sort_num = 3;
                break;

        }
        
        //sort_by 값으로 오름차순 정렬
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[sort_num], b[sort_num]);
            }
        });
        
        
        return answer;
    }
}