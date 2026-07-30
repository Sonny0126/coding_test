public class Solution {

    /*
     * 하노이 탑 재귀 함수
     *
     * n      : 이동할 원판 개수
     * start  : 시작 기둥
     * mid    : 보조 기둥
     * end    : 목표 기둥
     *
     * return : 이동 횟수
     */
    int hanoi(int n, char start, char mid, char end) {

        // 종료 조건
        // 원판 1개는 한 번만 이동하면 된다.
        if (n == 1) {
            return 1;
        }

        // 1단계:
        // 가장 큰 원판 위의 n-1개를 보조 기둥으로 이동
        int count1 = hanoi(n - 1, start, end, mid);

        // 2단계:
        // 가장 큰 원판 1개를 목표 기둥으로 이동
        int count2 = 1;

        // 3단계:
        // 보조 기둥에 있는 n-1개 원판을 목표 기둥으로 이동
        int count3 = hanoi(n - 1, mid, start, end);

        // 전체 이동 횟수 반환
        return count1 + count2 + count3;
    }


    public int Solution(int n) {

        int answer = hanoi(n, 'A', 'B', 'C');

        return answer;
    }
}