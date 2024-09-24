class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        // 음식 수에 따라 왼쪽 선수의 음식 추가
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;  // 한 선수당 먹는 양
            
            for (int j = 0; j < count; j++) {
                left.append(i);
                right.insert(0, i); // 오른쪽 선수 음식 왼쪽에 추가
            }
        }

        String water = "0";
        
        answer = left.toString() + water + right.toString();
        
        return answer;
    }
}