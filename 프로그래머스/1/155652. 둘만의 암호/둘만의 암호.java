class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String spelling = "abcdefghijklmnopqrstuvwxyz"; //알파벳 전체 값
        
        //spelling문자열에서 skip 문자열 제거
        for (char c : skip.toCharArray()) {
            spelling = spelling.replace(String.valueOf(c), "");
        }
        
        for(int i = 0; i<s.length(); i++){
            char word = s.charAt(i);
            int position = spelling.indexOf(word);
            int setPosition = position + index;
            
            if(position != -1){
                //setPosition 길이가 spelling보다 길이가 클 경우 계속 조정
                while (setPosition >= spelling.length()) {
                    setPosition -= spelling.length();
                }
                
                sb.append(spelling.charAt(setPosition));
            }
    
        }
        
        answer = sb.toString();
        
        return answer;
    }
}