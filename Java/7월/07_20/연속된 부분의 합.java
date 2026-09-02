import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int left = 0;
        int sum = 0;

        int start = 0;
        int end = sequence.length;

        for (int right = 0; right < sequence.length; right++) {

            // 오른쪽 포인터 확장
            sum += sequence[right];

            // 합이 너무 크면 왼쪽 포인터 이동
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            // 합이 k이면 후보 확인
            if (sum == k) {
                //지금 수열길이가 저장해둔 길이보다 짧으면 갱신
                if ((right - left) < (end - start)) {
                    start = left;
                    end = right;
                }
            }
        }

        return new int[]{start, end};
    }
}