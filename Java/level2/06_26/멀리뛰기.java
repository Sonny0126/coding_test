class Solution {
    public long solution(int n) {
        long answer = 0;

        //멀리뛰기 연습
        //효진이 1칸, 2칸 가능
        // n칸 있을 때 끝에 도달하는 방법 반환
        //끝에 도달하는 방법 값 / 1234567 reuturn

        //dp 사용
        long [] dp=new long [n+1];
        dp[1]=1;
        if(n>=2){
          dp[2]=2;
        }

        for(int i=3; i<=n; i++){
          dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }

        answer =dp[n];

        return answer;
    }
}