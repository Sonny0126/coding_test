class Solution {
  public int solution(int n) {
        
      int answer=0;

      //n이 0,1일 때
      if(n==0) return 0;
      if(n==1) return 1;

      //dp방법 사용
      int [] dp = new int [n+1];
      dp[0]=0;
      dp[1]=1;

      for(int i=2; i<=n ; i++){
        //n번째 피보나치 수를 1234567으로 나눈 나머지
        dp[i]=(dp[i-2]+dp[i-1])%1234567;
      }

      answer = dp[n];
      return answer;
    }
}