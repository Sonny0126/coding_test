class Solution {
    // 현재 숙련도(level)에서 모든 퍼즐을 푸는 데 걸리는 시간 계산
    public long getTime(int[] diffs, int[] times, int level) {

        long time = times[0]; // 첫 번째 퍼즐은 무조건 한 번만 풂
        for (int i = 1; i < diffs.length; i++) {
            // 1. diff <= level이면 퍼즐 안 틀리고 time_cur만큼 해결
            if (diffs[i] <= level) {
                time += times[i];
            }
            // 2. diff > level이면 diff-level 만큼 틀림
            else {
                int wrongCount = diffs[i] - level;
                // 현재 퍼즐(time_cur) + 이전 퍼즐(time_prev)를 다시 풀어야 함
                time += (long) wrongCount * (times[i] + times[i - 1]);
                time += times[i];
            }
        }
        return time;
    }

    public int solution(int[] diffs, int[] times, long limit) {

        int answer = 0;
        // 시간 안에 n개의 퍼즐 풀어야 함
        // 퍼즐의 난이도를 diff, 현재 퍼즐의 소요시간 time_cur,
        // 이전 퍼즐 소요시간 time_prev, 숙련도 level

        // 1. diff <= level이면 퍼즐 안 틀리고 time_cur만큼 해결
        // 2. diff > level이면 diff-level 만큼 틀림.
        //    틀릴 때마다 time_cur 사용,
        //    time_prev만큼 시간 사용해서 이전 퍼즐 풀고 와야 함
        // 3. 이전 퍼즐 풀 때 이전 퍼즐 난이도와 관계없이 안 틀림
        //    diff-level번 틀린 이후 현재 퍼즐을 다시 time_cur만큼 사용해서 해결

        // 제한시간 내 퍼즐 모두 해결하기 위한 숙련도의 최소 값 출력

        // 이진 탐색 범위
        int left = 1;
        int right = 0;

        // 숙련도의 최대값은 퍼즐의 최대 난이도
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        answer = right;

        // 최소 숙련도 찾기
        while (left <= right) {

            int level = (left + right) / 2;

            // 현재 숙련도에서 걸리는 시간 계산
            long time = getTime(diffs, times, level);

            // 제한 시간 안에 해결 가능
            if (time <= limit) {
                answer = level;
                // 더 낮은 숙련도로도 가능한지 확인
                right = level - 1;
            }

            // 제한 시간을 초과하면 숙련도를 높여야 함
            else {
                left = level + 1;
            }
        }

        return answer;
    }
}