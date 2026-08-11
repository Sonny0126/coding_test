class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] dp = new int[n][n];

        // 꼭대기
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {

                // 왼쪽 끝
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }

                // 오른쪽 끝
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }

                // 가운데
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        // 마지막 줄에서 가장 큰 값
        int answer = 0;

        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }

        return answer;
    }
}