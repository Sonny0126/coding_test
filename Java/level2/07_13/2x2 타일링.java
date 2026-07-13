class Solution {
    public int solution(int n) {
        int answer = 0;

        //가로n개 변수로 주어짐
        //길이 n=1 1 arr[1]
        //길이 n=2 2 arr[2]
        //길이 n=3 3 arr[3]
        //길이 n=4 5 arr[4]
        //길이 n=5 8      
        int [] dp= new int [n+1];
        dp[1]=1;
        if(n>=2) dp[2]=2;

        for(int i=3; i<=n; i++){
          dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }

        answer = dp[n];
        return answer;
    }
}