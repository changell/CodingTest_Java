import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats); // 오름차순으로 정렬
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i]; // 현재 돗자리 크기
            
            // 공원에서 각 좌표를 확인하며 돗자리를 놓을 수 있는지 체크
            for (int row = 0; row <= park.length - size; row++) {
                for (int col = 0; col <= park[0].length - size; col++) {
                    boolean canPlace = true; // 돗자리를 놓을 수 있는지 여부
                    
                    // 해당 위치에 돗자리를 놓을 수 있는지 확인
                    for (int x = 0; x < size; x++) {
                        for (int y = 0; y < size; y++) {
                            if (!park[row + x][col + y].equals("-1")) {
                                canPlace = false;
                                break;
                            }
                        }
                        if (!canPlace) break;
                    }
                    
                    // 돗자리를 놓을 수 있으면 해당 크기 반환
                    if (canPlace) return size;
                }
            }
        }
        
        // 모든 돗자리를 놓을 수 없는 경우
        return -1;
    }
}