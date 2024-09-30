class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        // 빈 병이 a개 이상일 때까지
        while (n >= a) {
            int newCola = (n / a) * b;  // 받을 수 있는 새로운 콜라의 병 수
            answer += newCola;       // 총 받은 콜라의 병 수에 누적
            n = (n % a) + newCola;      // 남은 빈 병 + 새로 받은 콜라를 마신 후의 빈 병
        }
        
        return answer;
    }
}