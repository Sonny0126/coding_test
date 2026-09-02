class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {

        int[] hopeTime = new int[schedules.length];

        // 희망 출근 시간 + 10분 저장
        for (int i = 0; i < schedules.length; i++) {

            int hopeHour = schedules[i] / 100;
            int hopeMin = schedules[i] % 100;

            hopeTime[i] = hopeHour * 60 + hopeMin + 10;
        }

        int count = 0;

        // 직원별 검사
        for (int i = 0; i < schedules.length; i++) {

            boolean success = true;

            // 7일 검사
            for (int j = 0; j < 7; j++) {

                int day = (startday + j - 1) % 7 + 1;

                // 토요일(6), 일요일(7) 제외
                if (day == 6 || day == 7) {
                    continue;
                }

                int hour = timelogs[i][j] / 100;
                int min = timelogs[i][j] % 100;

                int time = hour * 60 + min;

                // 늦었으면 실패
                if (time > hopeTime[i]) {
                    success = false;
                    break;
                }
            }

            if (success) {
                count++;
            }
        }

        return count;
    }
}