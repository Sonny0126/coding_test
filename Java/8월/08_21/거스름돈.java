class Solution {
    public int solution(int n, int[] money) {
        
        //money에 주어진 돈으로 거스름돈 주기
        //거슬러 줄 수 있는 모든 방법의개수 구하기

        int [] dp = new int [n+1];
        dp[0]=1;

        //money에 있는 가짓수를 통해 모든 개수 count
        for(int coin : money){
          for(int i=coin; i<=n; i++){
            dp[i]=(dp[i]+dp[i-coin])% 1000000007;
          }
        }

        return dp[n];
    }
}