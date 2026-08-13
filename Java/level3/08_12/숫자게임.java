import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        // 모든 사원 무작위로 자연수 받음
        // 각 사원 한번씩 경기
        // A팀 1명, B팀 1명 나와서 수 공개
        //큰 쪽 승리, 승리한 사원팀 +1
        //숫자 같으면 누구도 승점 얻지 않음
        // B팀원이 얻을 최대 승점

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < A.length && bIdx < B.length) {
            if (B[bIdx] > A[aIdx]) {
                // B가 A를 이김
                answer++;
                aIdx++;
                bIdx++;
            } 
            else {
                // B가 A를 이길 수 없음
                // 이 B는 버린다.
                bIdx++;
            }
        }

        return answer;
    }
}