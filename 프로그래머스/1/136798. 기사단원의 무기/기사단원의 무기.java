class Solution {
    public int solution(int number, int limit, int power) {
        int total = 0;

        for (int i = 1; i <= number; i++) {
            int divisorCount = countDivisors(i);

            // limit을 넘으면 power 사용, 아니면 약수 개수 사용
            int attack = (divisorCount > limit) ? power : divisorCount;

            total += attack;
        }

        return total;
    }

    public int countDivisors(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                // if i와 num / i가 다르면 둘 다 약수 
                if (i != num / i) {
                    count++;
                }
            }
        }
        return count;
    }
}