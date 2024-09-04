class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            boolean found = false;
        
            for (int j = i - 1; j >= 0; j--) {
                //if 현재 문자가 나왔는지 여부
                if (s.charAt(j) == c) {
                    answer[i] = i - j;
                    found = true;
                    break;
                }
            }
            //if 안 나왔으면 -1 적용
            if (!found) {
                answer[i] = -1;
            }

        }
        
        return answer;
    }
}