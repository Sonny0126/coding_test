class Solution {
    public int solution(int a, int b, int n) {
        
      //빈 병 a개 가져다주면, 콜라 b병을 주는 마트 
      //빈 병 n개를 가져다주면 몇 병 받을 수 있는지
      //빈 병 < a 라면, 빈 병 x
      //빈 병 2개 가져다주면 콜라 1개 받음

      int answer=0;

      while( n >= a){
        int getCola = (n/a) * b;
        int emptyCola = n % a;

        answer +=getCola;
        n = getCola + emptyCola;
      }
      
      return answer;

    }
}