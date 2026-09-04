class Solution {
    public int solution(int num) {

        //짝수면 /2
        //홀수면 *3 +1
        //1이 될때까지 반복
        //반복횟수
        long n = num;
        int count = 0; 

        if(n == 1)
          return count;

        while(n != 1){
          if(n %2 == 0){
            n /= 2;
          }
          else {
            n = n * 3 + 1;
          }
          count++;
        }

        if(count >= 500)
          count = -1;

        return count;
    }
}