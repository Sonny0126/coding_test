class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        //y값만 구하면 점이 찍히는 모든 개수 알 수 있다
        for (int x = 0; x <= d; x += k) {
            // x^2 + y^2 <= d^2
            // y <= sqrt(d^2 - x^2)
            int maxY = (int)Math.sqrt((long) d * d - (long) x * x);

            answer += maxY / k + 1;//y=0도 계산하기 위해 +1
        }

        return answer;
    }
}