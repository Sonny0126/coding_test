class Solution {

    //최대공약수 구하기
    public int gcd(int a, int b){
      int c;
      while(b>0){
        c=a%b;
        a=b;
        b=c;
      }
      return a;
    }

    //최소공배수 구하기
    public int lcm(int a, int b){
      return a*b / gcd(a,b);
    }
  
    public int solution(int[] arr) {
        int answer = 0;

        //최소공배수 풀이하는 문제
        //n개의 수의 최소공배수는 n개의 수들의 배수중 공통이 되는
        //가장 작은 숫자가 된다

        int num = arr[0];

        for(int i=1; i<arr.length; i++){
          num = lcm(num, arr[i]);
        }

        return num;
    }
}