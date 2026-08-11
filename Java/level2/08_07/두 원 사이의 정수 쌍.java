class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {

            // 큰 원에서 가능한 최대 y
            long maxY = (long) Math.sqrt(
                (long) r2 * r2 - (long) x * x
            );

            long minY;

            if (x >= r1) {
                minY = 0;
            } else {
                minY = (long) Math.sqrt(
                    (long) r1 * r1 - (long) x * x
                );

                // 작은 원의 경계도 포함하므로 제외하지 않음
                if (minY * minY <
                    (long) r1 * r1 - (long) x * x) {
                    // 올림 처리
                    minY++;
                }
            }

            // y = 0이 포함되면 한 번만 세기
            long count = (minY == 0)
                    ? maxY * 2 + 1
                    : (maxY - minY + 1) * 2;

            // +x, -x 대칭
            answer += count * 2;
        }

        // x = 0인 경우
        answer += (r2 - r1 + 1) * 2;

        return answer;
    }
}