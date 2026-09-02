import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        // 완료일 계산
        for(int i=0; i<progresses.length; i++){
          int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
          queue.offer(day);
        }

        List<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty()){
          int num = queue.poll();
          int count=1;

          while(!queue.isEmpty() && queue.peek () <= num){
            queue.poll();
            count++;
          }
          answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}