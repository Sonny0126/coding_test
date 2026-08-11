import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        //남은시간 N, 작업량 works
        //야근 피로도는 야근 시작한 시점에서 남은 일의 작업량 제곱하여 더한 값

        //숫자 큰 것부터 꺼낼수 있는 우선순위 큐를 하나 만들기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      
        //작업량 최대 힙에
        for(int work : works){
          pq.offer(work);
        }

        //n시간 동안 가장 큰 작업량 1씩 감소
        while(n>0){
          int max = pq.poll();

          //모든 작업이 끝난 경우
          if(max==0) break;

          pq.offer(max-1);
          n--;
        }

        //남은 작업량의 제곱 합
        long answer=0;

        //비기 전까지
        while(!pq.isEmpty()){
          long work = pq.poll();
          answer += work * work;
        }

        return answer;
    }
}