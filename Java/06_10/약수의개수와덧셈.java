class Solution {
    
  public int check(int n){
    int count=0;
    for(int i=1; i<=n; i++){
      if(n%i==0) count++;
    }
    return count;
  }

  public int solution(int left, int right) {
      //  left와 right 사이 값 중의 약수의 개수가 짝수면 덧셈
      //  약수의 개수가 홀수면 뺄셈 값 return 
      int sum=0;

      for(int i=left; i<=right; i++){
        if(check(i)%2==0) sum+=i;
        else sum -= i;
      }

      return sum;
    }
}