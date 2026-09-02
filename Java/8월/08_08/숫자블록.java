class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        for (long n = begin; n <= end; n++) {
            answer[(int) (n - begin)] = getBlock(n);
        }

        return answer;
    }

    private int getBlock(long n) {

        // 위치 1에는 블록이 설치되지 않음
        if (n == 1) {
            return 0;
        }

        // 블록 번호가 10,000,000 이하이므로
        // n 자체를 제외한 가장 큰 약수를 찾는다.
        if (n <= 10000000) {

            for (long i = 2; i * i <= n; i++) {

                if (n % i == 0) {
                    // i가 작은 약수이므로
                    // n / i가 더 큰 약수
                    return (int) (n / i);
                }
            }

            // 소수인 경우
            return 1;
        }

        // n > 10,000,000인 경우
        // n / i <= 10,000,000이어야 한다.
        //
        // 따라서
        // i >= n / 10,000,000
        long start = n / 10000000;

        for (long i = start; i * i <= n; i++) {

            if (n % i == 0) {
                return (int) (n / i);
            }
        }

        // 조건을 만족하는 약수가 없는 경우
        return 1;
    }
}