import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE; // 최소 길이
        int[] result = new int[0]; // 결과 배열
        
        while (right < sequence.length) {
            // 오른쪽 이동시키면서 합 증가
            sum += sequence[right];
            right++;
            
            // 구간의 합이 k를 초과하거나 같은 경우
            while (sum >= k) {
                if (sum == k) {
                    // 구간의 길이 계산
                    int length = right - left;
                    if (length < minLength) {
                        minLength = length;
                        result = new int[]{left, right - 1}; // [시작 인덱스, 끝 인덱스]
                    }
                }
                // 왼쪽 이동시키면서 합을 감소
                sum -= sequence[left];
                left++;
            }
        }
        
        return result;
    }
}