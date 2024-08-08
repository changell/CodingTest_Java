class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        
        for (int i = 0; i < signs.length; i++) {
            boolean sign = signs[i];
            if(sign){
                absolutes[i] *= 1;
            }else{
                absolutes[i] *= -1;
            }
            
            sum += absolutes[i];
        }
        
        return sum;
    }
}