import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        // 모든 값을 -1로 초기화
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < numbers.length; i++) {
            // while 스택이 비어있지 않고 스택의 맨위에 있는 인덱스에 해당하는 값이 현재 값보다 작은지 여부
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];  // 다음 큰 수를 현재 값으로 설정
            }
            stack.push(i); // 현재 인덱스를 스택에 저장
        }
        
        return answer;
    }
}