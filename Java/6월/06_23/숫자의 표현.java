class Solution {
    public int solution(int n) {
        int answer = 0;

        //n을 연속하는 자연수들로 표현하는 방법개수 출력
        for(int i=1; i<=n; i++){
          int sum=0;

          for(int j=i; j<=n; j++){
            sum+=j;
            if(sum==n) {
                answer++;
                break;
            }

            if(sum > n){
              break;
            }

          }
        }

        return answer;
    }
}