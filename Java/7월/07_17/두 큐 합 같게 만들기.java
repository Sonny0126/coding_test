import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        //각 큐배열에 값을 deque, enque 하면서 원소 합의 절반으로 만들기
        //만든 값의 최소값을 return
        long target=0;
        for(int num: queue1){
          target+=num;
        }
        for(int num: queue2){
          target+=num;
        }
        //진짜 target 값 구함
        //홀수면 불가
        if(target%2==1) return -1;
        else target /= 2;

        Queue<Integer> q1 =new LinkedList<>();
        Queue<Integer> q2 =new LinkedList<>();

        long sum1=0;
        long sum2=0;

        for(int num: queue1){
          sum1+=num;
          q1.offer(num);
        }
        for(int num:queue2){
          sum2+=num;
          q2.offer(num);
        }
        int cnt=0;
        //q1과 q2 각자 인큐, 디큐를 하면서 각 배열의 총합이 target과 동일하면 인큐, 디큐한 횟수를 cnt에 저장하고, 이 값의 최소값을 return, 원소 합을 같게 만들수 없다면 -1 return
        int limit = (queue1.length + queue2.length) * 3;

        while(cnt <= limit){

          if(sum1==target){
            return cnt;
          }
          if(sum1 >target){
            int temp=q1.poll();
            sum1 -= temp;
            sum2 += temp;
            q2.offer(temp);
          }

          else{
            int temp = q2.poll();
            sum2 -= temp;
            sum1 += temp;
            q1.offer(temp);
          }
          cnt++;
        }
        return -1;
    }
}