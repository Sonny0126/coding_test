import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        //입국심사 대기중
        //모든 심사대 비어있음
        // 심사 시간 최소로
        //기다리는 사람 수 n, 심사관 한명 걸리는 시간 times
        
        //오름차순나열
        Arrays.sort(times);

        long left =0;
        long right = (long) times[times.length-1]*n;
        long answer = right;

        while(left <= right){
          long mid = (left + right)/2;

          if(canPass(n, times, mid)){
            answer = mid;
            right = mid-1;
          }
          else{
            left = mid+1;
          }
        }

        return answer;
    }

    public boolean canPass(int n, int[]times, long time){
      long count=0;
      for(int t : times){
        count += time/t;
        if(count>= n){
          return true;
        }
      }
      return false;
    }
}