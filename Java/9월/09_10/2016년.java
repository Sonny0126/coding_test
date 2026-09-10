class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int[] days = {31, 29, 31, 30, 31, 30, 
                      31, 31, 30, 31, 30, 31};

        int total = 0;

        // a월 전까지의 날짜를 더한다.
        for (int i = 0; i < a - 1; i++) {
            total += days[i];
        }

        // b일에서 1을 빼는 이유:
        // 0일에서 하루 지난 일
        total += b - 1;

        return day[total % 7];
    }
}