import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

        //x->y
        //x에 n더하기
        //x에 2곱하기
        //x에 3곱하기
        //target +=n;
        //target *2;
        //target *3;

        //target에서 3방법을 이용하여 만들수 있는 방법의 수
        int[] dp = new int[y+1];
        Arrays.fill(dp, 10000001);
        dp[x]=0;
        for(int i=x; i<=y; i++){
          if(dp[i]==10000001) continue;
          if(i+n <= y){
            dp[i+n] = Math.min(dp[i+n], dp[i]+1);
          }
          if(i*2<=y){
            dp[i*2]= Math.min(dp[i*2], dp[i]+1);
          }
          if(i*3 <= y){
            dp[i*3] = Math.min(dp[i*3], dp[i]+1);
          }
        }

        return dp[y] == 10000001 ? -1 : dp[y];
    }
}