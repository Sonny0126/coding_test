class Solution {

    public int checkSame(int a, int b) {
        int temp = a > b ? a : b;

        for (int i = temp; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return -1;
    }

    public long solution(int w, int h) {
        long answer = 1;

        int num = checkSame(w, h);
        // 가로 길이 > 세로 길이
        if (w > h) {
            answer = (long) w * h - (w + h - num);
        }
        // 가로 길이 == 세로 길이
        else if (w == h) {
            answer = (long) w * h - w;
        }
        // 가로 길이 < 세로 길이
        else {
            answer = (long) w * h - (w + h - num);
        }

        return answer;
    }
}