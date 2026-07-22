class Solution {

    boolean isPrime(long n){
      if(n<2) return false;
      for(long i=2; i*i<=n; i++){
        if(n%i==0) return false;
      }
      return true;
    }

    public int solution(int n, int k) {
        //n ->  k로 변환할 때 아래 조건에 맞는 소수가 몇개인지
        //1. 소수 양쪽에 0이 있는경우
        //2. 소수오른쪽에만 0이 있고 왼쪽에는 아무것도 없는경우
        //3. 소수왼쪽에만 0이있고 오른쪽에는 아무것도 없는 경우
        //4. 소수양쪽에 아무것도 없는 경우
        String result = Integer.toString(n, k);
        String[] arr = result.split("0");

        int answer=0;

        for(String s: arr){
          if(s.equals("")) continue;

          long num = Long.parseLong(s);

          if(isPrime(num)) answer++;
        }

        return answer;
    }
}