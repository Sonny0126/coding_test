class Solution {
    public long solution(int[] sequence) {
        //수열의 연속 부분수령레 같은 길이의 펄 스 수열을 각 원소ㅗ끼리 곱하여 연속 펄스 부분 수열을 만들려고 한다
        // 펄스 수열이란 [1,-1,1,-1] or [-1,1,-1,1] 처럼 1or -1로 시작해서 1과 -1이 번갈아 나오는 수열이다

        //ex( [2,3,-6,1,3,-1,2,4]의 연속 부분 수열[3,-6,1]에 펄스 수열 [1,-1,1]곱하면 [3,6,1]이 된다)
        //연속 펄스 부분수열의 합 중 가자 큰 것을 return

        long answer =0;

        long sum1 =0;
        long sum2 =0;

        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;

        for(int i=0; i<sequence.length; i++){
          long pulse1;
          long pulse2;

          if(i%2==0){
            pulse1 = sequence[i];
            pulse2 = -sequence[i];
          }
          else{
            pulse1 = -sequence[i];
            pulse2 = sequence[i];
          }

          //Kddane
          sum1 = Math.max(pulse1, sum1 + pulse1);
          sum2 = Math.max(pulse2, sum2 + pulse2);

          max1 = Math.max(max1, sum1);
          max2 = Math.max(max2, sum2);
        }
        answer = Math.max(max1, max2);

        return answer;
    }
}