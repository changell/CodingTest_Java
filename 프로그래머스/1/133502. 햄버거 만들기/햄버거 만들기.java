import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int ing : ingredient) {
            stack.push(ing);

            //if 순서 완성되었는지 여부
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 && 
                    stack.get(size - 3) == 2 && 
                    stack.get(size - 2) == 3 && 
                    stack.get(size - 1) == 1) {
                    
                    //완성된 경우 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    //카운트 증가
                    answer++;
                }
            }
        }

        return answer;
    }
}