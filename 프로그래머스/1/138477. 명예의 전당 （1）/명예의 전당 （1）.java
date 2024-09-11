import java.util.*;

public class Solution {
    public static int[] solution(int k, int[] score) {
        //작은 값이 우선순위
        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        // 매일 점수 처리
        for (int s : score) {
            // 명예의 전당에 현재 점수 추가
            hallOfFame.add(s);

            // if 크기가 k를 초과 여부
            if (hallOfFame.size() > k) {
                hallOfFame.poll(); //가장 작은 값 제거
            }

            // 현재 명예의 전당 중에서 가장 작은 점수를 결과 리스트 추가
            result.add(hallOfFame.peek());
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
    
}
