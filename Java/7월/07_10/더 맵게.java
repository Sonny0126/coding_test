import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        //섞은 스코빌 지수 = 가장 맵지 않은 스코빌 지수 + (두밴째로 맵지 않은 음식의 스코빌 지수 x 2)
        // 스코빌 지수 >= K 되게 하는 최소지수
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
          pq.add(scoville[i]);
        }

        int answer=0;
        int MIN = 10000001;

        while(pq.peek() < K){
          if(pq.size()==1){
            return -1;
          }

          int first = pq.poll();
          int second = pq.poll();

          int mix = first + second *2;
          pq.offer(mix);
          answer++;
        }

        return answer;
    }
}