import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        // 뒤에서부터 m개씩
        for (int i = score.length - m; i >= 0; i -= m) {
            // 최저 점수는 현재 구간의 첫 번째
            int boxPrice = score[i] * m;
            answer += boxPrice;
        }
        
        return answer;
    }
}