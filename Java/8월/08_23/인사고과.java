import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // 완호의 원본 점수 정보 저장
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;

        // 근무태도점수 내림차순, 같으면 동료평가점수 오름차순 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int rank = 1;
        int maxScoreB = 0;

        for (int[] score : scores) {
            int a = score[0];
            int b = score[1];

            // 동료평가점수가 이전의 최댓값보다 작으면 탈락 대상
            if (b < maxScoreB) {
                // 탈락한 사원이 완호인 경우
                if (a == wanhoA && b == wanhoB) {
                    return -1;
                }
            } else {
                // 탈락하지 않은 유효한 사원
                maxScoreB = Math.max(maxScoreB, b);
                
                // 완호보다 점수 합이 크면 완호 등수 밀림
                if (a + b > wanhoSum) {
                    rank++;
                }
            }
        }

        return rank;
    }
}