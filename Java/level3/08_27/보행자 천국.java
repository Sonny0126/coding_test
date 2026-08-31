class Solution {

    static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {

        // 0 : 아래 방향으로 이동해서 도착
        // 1 : 오른쪽 방향으로 이동해서 도착
        int[][][] dp = new int[m][n][2];

        dp[0][0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (cityMap[r][c] == 1) {
                    continue;
                }
                if (r == 0 && c == 0) {
                    continue;
                }
                // 위쪽 -> 현재
                if (r > 0 && cityMap[r - 1][c] != 1) {
                    if (cityMap[r - 1][c] == 2) {
                        // 직진만 가능
                        dp[r][c][0] = dp[r - 1][c][0];
                    } 
                    else {
                        // 방향 전환 가능
                        dp[r][c][0] = (dp[r - 1][c][0] + dp[r - 1][c][1]) % MOD;
                    }
                }

                // 왼쪽 -> 현재
                if (c > 0 && cityMap[r][c - 1] != 1) {
                    if (cityMap[r][c - 1] == 2) {
                        // 직진만 가능
                        dp[r][c][1] = dp[r][c - 1][1];
                    } 
                    else {
                        // 방향 전환 가능
                        dp[r][c][1] =
                            (dp[r][c - 1][0] + dp[r][c - 1][1]) % MOD;
                    }
                }
            }
        }
        // 도착점에 아래 방향과 오른쪽 방향으로 도착한 모든 경로 수를 더해 MOD로 나눈 값
        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}