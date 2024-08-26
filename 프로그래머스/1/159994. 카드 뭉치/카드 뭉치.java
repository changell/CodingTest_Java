class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        for(int i = 0; i < goal.length; i++){
            //if card1[0] == goal[i] 여부
            if(goal[i].equals(cards1[0])){
                removeElement(cards1, 0);   // 첫번째 인덱스 제거
                
            //if card2[0] == goal[i] 여부
            }else if(goal[i].equals(cards2[0])){
                removeElement(cards2, 0);   // 첫번째 인덱스 제거
                
            //else goal[i] 모든 값 순회 여부
            }else{
                answer = "No";
            }
            
        }
            
        return answer;
    }
    
    public static String[] removeElement(String[] array, int index){
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1]; // 뒤에 있는 문자열을 앞으로 땡김
        }
        // 배열의 마지막 요소를 null로 설정하여 제거
        array[array.length - 1] = null;

        return array;
    }
}