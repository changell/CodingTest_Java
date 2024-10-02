import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});  // 시작 값, 연산 횟수
        
        // 방문 여부 체크 배열
        boolean[] visited = new boolean[y + 1];
        visited[x] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = current[0];  // 현재 값
            answer = current[1];  // 현재까지의 연산 횟수
            
            // if 현재 값이 y에 도달했는지 여부
            if (currentValue == y) {
                return answer;
            }
            
            // 다음에 가능한 연산들을 수행
            int[] nextValues = {currentValue + n, currentValue * 2, currentValue * 3};
            
            for (int nextValue : nextValues) {
                // 범위를 벗어나지 않고, 아직 방문하지 않은 값이라면 큐에 추가
                if (nextValue <= y && !visited[nextValue]) {
                    visited[nextValue] = true;
                    queue.add(new int[]{nextValue, answer + 1});
                }
            }
        }
        return -1;
    }
}