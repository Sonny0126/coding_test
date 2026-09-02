class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = check(n);

        return answer;
    }

    public int check(int n){
      int count=0;
      for(int i=1; i<=n; i++){
        if(n%i==0) count += i;
      }
      return count;
    }
}