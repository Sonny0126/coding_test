import java.util.*;

public class Solution {
    public int solution(int n) {

        // k간 점프, 현재 온 거리 x2 순간이동 
        // 순간이동은 건전지 사용 x
        // but 점프는 k이동시 K만큼 소요
        //거리 N만큼 있는 곳 가려함
        // 점프 이동 최소화하고 이동


        //갈 수 있는 방법 개수 중 최소 방법 개수 출력
        int battery=0;

        // n을 2로 계속 나누면서, 나머지가 1이면(=홀수면) 배터리 사용한 것
        while (n > 0) {
            if (n % 2 == 1) {
                battery++; // 홀수면 점프(+1), 배터리 ++
            }
            n /= 2; // 순간이동 사용
        }

        return battery;
    }
}