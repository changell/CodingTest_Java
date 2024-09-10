class Solution {
    public static int solution(int[] wallet, int[] bill){
         // 지갑과 지폐의 크기를 정렬하여 가로와 세로 크기 구분
        int[] ws = {Math.min(wallet[0], wallet[1]), Math.max(wallet[0], wallet[1])};
        int[] bs = {Math.min(bill[0], bill[1]), Math.max(bill[0], bill[1])};

        int answer = 0;

        // 지폐가 지갑에 들어갈 수 있을 때까지 반복
        while (bs[0] > ws[0] || bs[1] > ws[1]) {
            if (bs[0] > bs[1]) {
                // 지폐의 긴 쪽을 반으로 접는다.
                bs[0] /= 2;
            } else {
                // 지폐의 짧은 쪽을 반으로 접는다.
                bs[1] /= 2;
            }
            answer++;
            
            // 지폐의 크기가 지갑의 크기에 맞는지 확인
            if ((bs[0] <= ws[0] && bs[1] <= ws[1]) ||
                (bs[1] <= ws[0] && bs[0] <= ws[1])) {
                break;
            }
        }

        return answer;
    }
}